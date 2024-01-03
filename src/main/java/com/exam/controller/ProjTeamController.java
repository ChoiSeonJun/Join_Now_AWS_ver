package com.exam.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.amazonaws.auth.SdkClock.Instance;
import com.exam.dto.MeetingDTO;
import com.exam.dto.MeetingPageDTO;
import com.exam.dto.ScheduleDTO;
import com.exam.dto.TeamDTO;
import com.exam.dto.TeamMemberDTO;
import com.exam.dto.UploadDTO;
import com.exam.dto.UserInfoDTO;
import com.exam.navercloud.openapi.service.ObjectStorageService;
import com.exam.service.ProjTeamServiceImpl;
import com.exam.service.TeamService;
import com.exam.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Controller
@Slf4j
@RequestMapping("/team")
public class ProjTeamController {

  private static final Logger log = LoggerFactory.getLogger(ProjTeamController.class);

  @Autowired
  private ProjTeamServiceImpl projTeamService;

  @Autowired
  private TeamService teamService;

  @Autowired
  private UserService userService;

  @Autowired
  ObjectStorageService storageService;

  // 팀정보
  @GetMapping("/{teamId}")
  public String info(@PathVariable int teamId, HttpSession session, Model model) {

    log.info("info works");

    UserInfoDTO userInfoDTO = (UserInfoDTO) session.getAttribute("loginInfo");
    TeamDTO teamDTO = teamService.selectByTeamId(teamId);
    List<TeamMemberDTO> teamMemberDTO = teamService.selectMemberListByTeamId(teamId);

    List<String> members = new ArrayList<>();

    for (TeamMemberDTO dto : teamMemberDTO) {
      UserInfoDTO tmp = userService.selectAllById(dto.getUserId());
      members.add(tmp.getUsername());
    }

    System.out.println(members);
    model.addAttribute("teamDTO", teamDTO);
    model.addAttribute("memberList", teamMemberDTO);
    model.addAttribute("members", members);
    model.addAttribute("userInfo", userInfoDTO);

    return "info";
  }

  // 팀 소개 수정 페이지
  @GetMapping("/update/{teamId}")
  public String infoRetrieve(@PathVariable int teamId, Model model, HttpSession session) {
    log.info("info retrieve works");

    UserInfoDTO userInfoDTO = (UserInfoDTO) session.getAttribute("loginInfo");
    TeamDTO teamDTO = teamService.selectByTeamId(teamId);

    model.addAttribute("teamDTO", teamDTO);
    model.addAttribute("userInfo", userInfoDTO);


    return "infoRetrieve";
  }

  // 팀 소개 수정 작업
  @GetMapping("/update/retrieve.do/{teamId}")
  public String infoRetrieveDo(@PathVariable int teamId, TeamDTO teamDTO, HttpSession session, Model model) {
    log.info("info retrieve do works");

    UserInfoDTO userInfoDTO = (UserInfoDTO) session.getAttribute("loginInfo");
    teamDTO.setTeamId(teamId);
    teamService.updateTeamInfoById(teamDTO);
    model.addAttribute("userInfo", userInfoDTO);

    return "infoRetrieve";
  }


  @PostMapping("/teamupload/{teamId}")
  public String teamupload(@PathVariable int teamId, UploadDTO dto, Model m, HttpSession session) {

    // 세션에서 id값 받아오기
    UserInfoDTO userInfoDTO = (UserInfoDTO) session.getAttribute("loginInfo");
    int id = userInfoDTO.getId();
    // 현재 로그인된 id에 해당하는 정보 받아와서 출력
    UserInfoDTO info = userService.selectAllById(id);
    m.addAttribute("UserInfoDTO", info);

    // 팀정보 가져오기
    TeamDTO teamDTO = teamService.selectByTeamId(teamId);
    m.addAttribute("teamDTO", teamDTO);

    String theText = dto.getTheText();
    MultipartFile theFile = dto.getTheFile();

    // 파일정보
    long size = theFile.getSize();
    String name = theFile.getName();
    String originalFilename = theFile.getOriginalFilename();
    String contentType = theFile.getContentType();


    System.out.println(theText);
    System.out.println(size);
    System.out.println(name);
    System.out.println(originalFilename);
    System.out.println(contentType);

    String teamProfileName = Integer.toString(teamDTO.getTeamId()) + ".jpg";
    File f = new File("c:\\upload", teamProfileName);

    try {
      theFile.transferTo(f);
    } catch (IllegalStateException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }



    // 클라우드에 저장
    storageService.upload(teamProfileName, "c:\\upload\\" + teamProfileName);

    // 파일 삭제
    String filePath = "c:\\upload\\" + teamProfileName;
    File file = new File(filePath);

    if (file.exists()) {
      boolean deleted = file.delete();
      if (deleted) {
        System.out.println("파일이 삭제되었습니다.");
      } else {
        System.out.println("파일 삭제에 실패했습니다.");
      }
    } else {
      System.out.println("파일이 존재하지 않습니다.");
    }

    return "redirect:/team/" + teamId;
  }

  /**
   * 일정표 기능 구현
   */

  // 일정표
  @GetMapping("/schedule/{teamId}")
  public String schedule(@PathVariable int teamId, HttpSession session, Model model) {
    UserInfoDTO userInfoDTO = (UserInfoDTO) session.getAttribute("loginInfo");
    TeamDTO teamDTO = teamService.selectByTeamId(teamId);

    model.addAttribute("userInfo", userInfoDTO);
    model.addAttribute("teamDTO", teamDTO);
    return "schedule";
  }

  // 일정표 이벤트 조회
  @GetMapping("/schedule/select/{teamId}")
  public @ResponseBody List<ScheduleDTO> selectEvents(@PathVariable int teamId, HttpSession session,
      Model model) {
    List<ScheduleDTO> events = projTeamService.selectAllEventbyId(teamId);
    if (events == null) {
      return null;
    } else {
      return events;
    }
  }

  // 일정표 - 이벤트 저장 기능
  @PostMapping("/schedule/add/event/{teamId}")
  public String saveEvent(@RequestBody ScheduleDTO scheduleDTO, @PathVariable int teamId,
      Model model) {
    System.out.println("event insert test");

    HashMap<String, Object> map = new HashMap<>();
    map.put("teamId", teamId);
    map.put("scheduleDTO", scheduleDTO);

    System.out.println(scheduleDTO);
    int n = projTeamService.insertEvent(map);

    return "schedule";
  }

  // 일정표 - 이벤트 수정 기능
  @PostMapping("/schedule/update/event/{teamId}")
  public String updateEvent(@RequestBody ScheduleDTO scheduleDTO, @PathVariable int teamId) {
    System.out.println("event update test");


    try {
      projTeamService.updateEvent(scheduleDTO);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return "schedule";
  }

  // 일정표 - 이벤트 삭제 기능
  @PostMapping("/schedule/delete/event/{teamId}")
  public String deleteEvent(@RequestBody ScheduleDTO scheduleDTO, @PathVariable int teamId) {

    int check_num = projTeamService.deleteEvent(scheduleDTO);

    if (check_num == 0) {
      log.info("schedule Table has already been EMPTY");
    }

    return "schedule";
  }


  /**
   * 희의록
   */

  // 회의록
  @GetMapping("/meeting/{teamId}/{curPage}")
  public String meeting(@PathVariable int teamId,
      @PathVariable(value = "curPage", required = false) int curPage, Model model,
      HttpSession session) {
    UserInfoDTO userInfoDTO = (UserInfoDTO) session.getAttribute("loginInfo");
    TeamDTO teamDTO = teamService.selectByTeamId(teamId);

    HashMap<String, Integer> hashmap = new HashMap<>();

    hashmap.put("teamId", teamId);
    hashmap.put("curPage", curPage);

    MeetingPageDTO pageDTO = projTeamService.getAllPost(hashmap);
    model.addAttribute("pageDTO", pageDTO);
    model.addAttribute("teamId", teamId);
    model.addAttribute("teamDTO", teamDTO);
    model.addAttribute("userInfo", userInfoDTO);
    return "meeting";
  }

  // 회의록 작성 페이지
  @GetMapping("/meeting/write/{teamId}")
  public String meetingWrite(@PathVariable int teamId, HttpSession session, Model model) {
    UserInfoDTO userInfoDTO = (UserInfoDTO) session.getAttribute("loginInfo");
    model.addAttribute("userInfo", userInfoDTO);
    model.addAttribute("teamId", teamId);
    return "meetingWrite";
  }

  // 회의록 작성
  @GetMapping("/meeting/write.do/{teamId}")
  public String addMeeeting(@PathVariable int teamId, @ModelAttribute MeetingDTO meetingDTO,
      HttpSession session, Model model) {
    UserInfoDTO userInfoDTO = (UserInfoDTO) session.getAttribute("loginInfo");
    meetingDTO.setTeamId(teamId);
    meetingDTO.setWriter(userInfoDTO.getNickname());

    log.info("meetingWrite test");

    projTeamService.addMeetingPost(meetingDTO);
    model.addAttribute("userInfo", userInfoDTO);
    return "meetingWrite";
  }

  /**
   * 구현해야 할 사항 teamId 값을 @PathVariable로 쿼리 파라미터로 받아와서 teamId, id 값을 map에 넣은 후 서비스로 전달
   */
  // 회의록 상세페이지
  @GetMapping("/meeting/detail/{teamId}/{meetingNo}")
  public String meetingDetail(@PathVariable int teamId, @PathVariable int meetingNo,
      HttpSession session, Model model) {

    HashMap<String, Integer> map = new HashMap<>();
    map.put("teamId", teamId);
    map.put("meetingNo", meetingNo);

    System.out.println("meeting detail test");

    UserInfoDTO userInfoDTO = (UserInfoDTO) session.getAttribute("loginInfo");
    MeetingDTO meetingDTO = projTeamService.selectOneById(map);
    meetingDTO.setMeetingNo(meetingNo);
    meetingDTO.setTeamId(teamId);
    model.addAttribute("meetingDTO", meetingDTO);
    model.addAttribute("userInfo", userInfoDTO);

    return "meetingDetail";
  }

  // 회의록 삭제
  @GetMapping("/meeting/delete/{teamId}/{meetingNo}")
  public String meetingDelete(@PathVariable int teamId, @PathVariable int meetingNo, HttpSession session, Model model) {
    UserInfoDTO userInfoDTO = (UserInfoDTO) session.getAttribute("loginInfo");

    HashMap<String, Integer> map = new HashMap<>();
    map.put("teamId", teamId);
    map.put("meetingNo", meetingNo);

    projTeamService.deleteOneById(map);
    model.addAttribute("userInfo", userInfoDTO);

    return "meetingRetrieve";
  }

  // 회의록 수정페이지
  @GetMapping("/meeting/retrieve/{teamId}/{meetingNo}")
  public String meetingRetrieve(@PathVariable int teamId, @PathVariable int meetingNo,
      HttpSession session, Model model) {
    UserInfoDTO userInfoDTO = (UserInfoDTO) session.getAttribute("loginInfo");

    HashMap<String, Integer> map = new HashMap<>();
    map.put("teamId", teamId);
    map.put("meetingNo", meetingNo);

    System.out.println("meeting retrieve test");

    MeetingDTO meetingDTO = projTeamService.selectOneById(map);

    model.addAttribute("meetingDTO", meetingDTO);
    model.addAttribute("userInfo", userInfoDTO);

    return "meetingRetrieve";
  }

  // 회의록 수정 기능
  @GetMapping("/meeting/retrieve.do/{teamId}/{meetingNo}")
  public String meetingRetrieveDo(@PathVariable int teamId, @PathVariable int meetingNo,
      MeetingDTO meetingDTO, HttpSession session, Model model) {

    UserInfoDTO userInfoDTO = (UserInfoDTO) session.getAttribute("loginInfo");
    HashMap<String, Object> map = new HashMap<>();
    map.put("teamId", teamId);
    map.put("meetingNo", meetingNo);
    map.put("meetingDTO", meetingDTO);

    System.out.println("meeting retrieve test");
    System.out.println(meetingDTO.getTitle());
    projTeamService.updateMeetingById(map);

    model.addAttribute("userInfo", userInfoDTO);
    return "meetingRetrieve";
  }

  // 회의록 검색
  @GetMapping("/meeting/search/{teamId}")
  public String meetingSearch(@PathVariable int teamId, @RequestParam String keyword, @RequestParam String searchType, Model model,
                              HttpSession session) {
    List<MeetingDTO> listMeetingDTO = null;
    UserInfoDTO userInfoDTO = (UserInfoDTO) session.getAttribute("loginInfo");
    TeamDTO teamDTO = teamService.selectByTeamId(teamId);
    
    HashMap<String, Object> map = new HashMap<String, Object>();
    map.put("keyword", keyword);
    map.put("teamId", teamId);
    
    if (searchType == "all") {
      listMeetingDTO = projTeamService.searchAll(map);
      System.out.println("ddd");
    } else if(searchType == "title") {
      listMeetingDTO = projTeamService.searchTitle(map);
    } else {
      listMeetingDTO = projTeamService.searchContent(map);
    }
  
    model.addAttribute("listMeetingDTO", listMeetingDTO);
    model.addAttribute("teamId", teamId);
    model.addAttribute("teamDTO", teamDTO);
    model.addAttribute("userInfo", userInfoDTO);
    return "meetingSearch";
  }



  /**
   * 팀 신청관리
   * 
   * @return
   */

  @GetMapping("/teamManage/{teamId}")
  public String teamManage(@PathVariable int teamId, Model model, HttpSession session) {
    UserInfoDTO userInfoDTO = (UserInfoDTO) session.getAttribute("loginInfo");
    List<TeamMemberDTO> memberList = teamService.selectMemberListByTeamId(teamId);

    List<UserInfoDTO> userList = new ArrayList<UserInfoDTO>();
    for (TeamMemberDTO dto : memberList) {
      userList.add(userService.selectAllById(dto.getUserId()));
    }

    TeamDTO teamDTO = teamService.selectByTeamId(teamId);
    boolean leader = false;
    if (userInfoDTO.getId() == teamDTO.getUserId()) {
      leader = true;
    }

    System.out.println(leader);
    model.addAttribute("memberList", userList);
    model.addAttribute("leader", leader);
    model.addAttribute("teamId", teamId);
    model.addAttribute("teamDTO", teamDTO);
    model.addAttribute("userInfo", userInfoDTO);

    return "TeamManagementPage";
  }

  @PostMapping("/memberDelete/{teamId}/{userId}")
  public String teamMemberDelete(@PathVariable int teamId, @PathVariable int userId) {
    teamService.teamMemberDel(userId);
    System.out.println("memberDel" + teamId + userId);
    return "redirect:/team/teamManage/" + teamId;
  }

  @PostMapping("/teamDelete")
  @Transactional
  public String teamDelete(@RequestParam int teamId, HttpSession session) {
    try {
      teamService.deleteTeamMemberByteamId(teamId);
      teamService.deleteTeamMemberByteamId(teamId);
      log.info("teamId team is deleted now");
    } catch (Exception e) {
      log.warn("It have deleted a team. Please check your system.");
      e.printStackTrace();
    }
    return "redirect:/app/teamList";
  }


}
