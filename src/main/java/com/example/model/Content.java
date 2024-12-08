package com.example.model;

public class Content {
	public String contentID;
	public String contentTitle;
	public String contentDescription;
	public String contentUploadDate;
	public String contentType;
	public String programID;
	public String link;
	
	public Content() {
		
	}
	
	public Content(String contentID, String contentTitle, String contentDescription, String contentUploadDate, String contentType, String programID, String link) {
        this.contentID = contentID;
        this.contentTitle = contentTitle;
        this.contentDescription = contentDescription;
        this.contentUploadDate = contentUploadDate;
        this.contentType = contentType;
        this.programID = programID;
        this.link = link;
    }
	
	// Getter and Setter for contentID
    public String getContentID() {
        return contentID;
    }

    public void setContentID(String contentID) {
        this.contentID = contentID;
    }

    // Getter and Setter for contentTitle
    public String getContentTitle() {
        return contentTitle;
    }

    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle;
    }

    // Getter and Setter for contentDescription
    public String getContentDescription() {
        return contentDescription;
    }

    public void setContentDescription(String contentDescription) {
        this.contentDescription = contentDescription;
    }

    // Getter and Setter for contentUploadDate
    public String getContentUploadDate() {
        return contentUploadDate;
    }

    public void setContentUploadDate(String contentUploadDate) {
        this.contentUploadDate = contentUploadDate;
    }

    // Getter and Setter for contentType
    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    // Getter and Setter for programID
    public String getProgramID() {
        return programID;
    }

    public void setProgramID(String programID) {
        this.programID = programID;
    }

    // Getter and Setter for link
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
	
}
