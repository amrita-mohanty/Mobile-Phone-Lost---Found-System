package springapp.domain;

public class Message {

    private String message;
    private String dateReceived;
    private String latitude;
    private String longitude;
    
    public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(String dateReceived) {
        this.dateReceived = dateReceived;
    }

    @Override
    public String toString() {
        return "Message [message=" + message + ", dateReceived=" + dateReceived + ", longitude=" + longitude + ", latitude=" + latitude 
                + "]";
    }

}
