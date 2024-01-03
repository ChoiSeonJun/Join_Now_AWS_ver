package com.exam.dto;

import org.apache.ibatis.type.Alias;

@Alias("CommentDTO")
public class CommentDTO {
	
		int commentNo;
		int postNo;
		String content;
		boolean delete_yn;
		String create_date;
		String modified_date;
		int writer;
		String nickname;
		
		public CommentDTO() {}


		public CommentDTO(int commentNo, int postNo, String content, int writer, boolean delete_yn, String create_date,
				String modified_date) {
			this.commentNo = commentNo;
			this.postNo = postNo;
			this.content = content;
			this.writer = writer;
			this.delete_yn = delete_yn;
			this.create_date = create_date;
			this.modified_date = modified_date;
		}



		public String getNickname() {
			return nickname;
		}


		public void setNickname(String nickname) {
			this.nickname = nickname;
		}


		public int getCommentNo() {
			return commentNo;
		}

		public void setCommentNo(int commentNo) {
			this.commentNo = commentNo;
		}

		public int getPostNo() {
			return postNo;
		}

		public void setPostNo(int postNo) {
			this.postNo = postNo;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public int getWriter() {
			return writer;
		}

		public void setWriter(int writer) {
			this.writer = writer;
		}

		public boolean isDelete_yn() {
			return delete_yn;
		}

		public void setDelete_yn(boolean delete_yn) {
			this.delete_yn = delete_yn;
		}

		public String getCreate_date() {
			return create_date;
		}

		public void setCreate_date(String create_date) {
			this.create_date = create_date;
		}

		public String getModified_date() {
			return modified_date;
		}

		public void setModified_date(String modified_date) {
			this.modified_date = modified_date;
		}

		@Override
		public String toString() {
			return "CommentDTO [commentNo=" + commentNo + ", postNo=" + postNo + ", content=" + content + ", writer="
					+ writer + ", delete_yn=" + delete_yn + ", create_date=" + create_date + ", modified_date="
					+ modified_date + "]";
		}

		
}
