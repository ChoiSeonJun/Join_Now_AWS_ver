var calendar = null;
var event = {
		title : "",
		start : "",
		end : "",
		backgroundColor : ""
	};

$(document).ready(function() {
	var calendarEl = document.getElementById('calendar');
	var calendar = new FullCalendar.Calendar(calendarEl, {
		headerToolbar : {
			start : 'dayGridMonth,dayGridWeek,dayGridDay today save',
			center : 'title',
			end : 'prev,next',
		},
		footerToolbar : {
			start : '',
			center : '',
			end : ''
		},
		customButtons: {
		    save: {
		      text: 'save',
		      click: function() {
		        if (confirm("저장하시겠습니까?")){
		        	save();
		        }
		     
		      }
		    }
		  },
		firstDay: 1,
		titleFormat: function (date) {
		year = date.date.year;
        month = date.date.month + 1;

		return year + "년 " + month + "월";
		},

		navLinks : true, // can click day/week names to navigate views
		editable : true,
		dayMaxEvents : true, // allow "more" link when too many events
		selectable : true, // 마우스로 선택한 날짜 클릭 시 색상 변환
		locale : 'ko', // 한국어 적용
		height : 30,
		contentHeight : 'auto', // 일정개수에 맞게 달력 크기 조절
// eventAdd : function() {// 이벤트가 추가되면 발생하는 이벤트
// console.log()
// },
		
		events : function(info, successCallback, failureCallback) {
            // 서버에서 이벤트 데이터를 가져오는 AJAX 요청
            $.ajax({
                url: './schedule/select/event', // 데이터를 제공하는 서버 엔드포인트로 수정
                type: 'POST', // GET 또는 POST로 요청을 보냄
                dataType: 'json',
                success: function(eventData) {
                    // 서버에서 받은 이벤트 데이터를 FullCalendar에 전달
                    successCallback(eventData);
                },
                error: function(error) {
                    // 에러 발생 시 처리
                    console.error('이벤트 데이터를 가져오는 중 에러 발생:', error);
                }
            });
        },
        
        eventClick: function(info) {
        	editAndDelete(info);
        },
		
		select : function(info) {
			addEvent(info);
			
			console.log(calendar.getEvents());
			// eventChange: function (obj) { // 이벤트가 수정되면 발생하는 이벤트
			// allEvent = calendar.getEvents();
			// console.log(allEvent);
			// },
			// eventRemove: function (obj) { // 이벤트가 삭제되면 발생하는 이벤트
			// console.log(obj);
			// },

		},

	});

	calendar.render();
	
	function addEvent(info){
		console.log(info);

		$("#backDropModal").modal("show"); // modal 나타내기

		$("#event_start_date").val(info.startStr);
		$("#event_end_date").val(info.endStr);
		
		$("#addEvent").off('click').on("click", function() {
			
			event.title = $("#eventContent").val().trim();
			event.start = $("#event_start_date").val();
			event.end = $("#event_end_date").val();
			event.backgroundColor = $("#event_color").val();
			
			// 일정 검증
			if (event.title == null || event.title == "") {
				alert("내용을 입력하세요.");
			} else if (new Date(event.end) - new Date(event.start) < 0) {
				alert("종료일이 시작일보다 먼저입니다.");
			} else if (event.backgroundColor == null || event.backgroundColor == "") {
				alert("색상을 선택해주세요.");
			} else {

				$("#backDropModal").modal("hide");
				calendar.addEvent(event);
				$("#eventContent").val("");
				
				
			}
			console.log(calendar.getEvents());

		});
	}
	
	function save(){
		// 서버로 데이터 전송
		let allEvent = calendar.getEvents();
        $.ajax({
            type: 'POST',
            url: './schedule/add/event',
            data: JSON.stringify(allEvent),
            contentType: 'application/json; charset=utf-8',
            success: function(response) {
                console.log('데이터 전송 성공. 서버 응답: ');
            	
            },
            error: function(xhr, status, error) {
                console.error('데이터 전송 실패. 에러: ' + error);
            }
        });
	}
	
	function insertModalOpen(arg){
		
	    if('<%=sessionId%>' == null){
			alert();
			location.href='login.jsp';
		}
	}
	
	function editAndDelete(info){
		$('#editDeleteModal').modal('show');
		
		// 수정 모달창 열릴 때 누른 이벤트 값 보이도록 설정
		$("#mEventContent").val(info.event.title);
		$("#mEvent_start_date").val(info.event.startStr);
		$("#mEvent_end_date").val(info.event.endStr);
		$("#mEvent_color").val(info.event.backgroundColor);
		
		$("#editEventButton").off('click').on("click", function() {
			const modifiedEvent = {
				title : $("#mEventContent").val().trim(),
				start : $("#mEvent_start_date").val(),
				end : $("#mEvent_end_date").val(),
				backgroundColor : $("#mEvent_color").val()
			};
			console.log(modifiedEvent);
			$.ajax({
				type:'POST',
				url: './schedule/update/event',
				data: JSON.stringify(modifiedEvent),
				contentType: 'application/json; charset=utf-8',
				success: function(response) {
	                console.log('데이터 전송 성공. 서버 응답: ');
	                $("#backDropModal").modal("hide");
	            	
	            },
	            error: function(xhr, status, error) {
	                console.error('데이터 전송 실패. 에러: ' + error);
	            }
			});
		});
		
		$("#deleteEventButton").off('click').on("click", function() {
			$.ajax({
				type:'POST',
				url: './schedule/delete/event',
				data: JSON.stringify({title:$("#mEventContent").val().trim()}),
				contentType: 'application/json; charset=utf-8',
				success: function(response) {
	                console.log('데이터 전송 성공. 서버 응답: ');
	                $("#backDropModal").modal("hide");
	            	
	            },
	            error: function(xhr, status, error) {
	                console.error('데이터 전송 실패. 에러: ' + error);
	            }
			});
		});
		
	}
	
});
