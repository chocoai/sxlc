package cn.membermng.model; 

public class UntreatedMessageEntity {
	
	private int 		stationMessageNum=0;				//站内信息数量
	private int 		letterNum=0;										//站内信数量
	private int		applicationFriendNum=0;				//好友申请数量
	
	
	public int getStationMessageNum() {
		return stationMessageNum;
	}
	public void setStationMessageNum(int stationMessageNum) {
		this.stationMessageNum = stationMessageNum;
	}
	public int getLetterNum() {
		return letterNum;
	}
	public void setLetterNum(int letterNum) {
		this.letterNum = letterNum;
	}
	public int getApplicationFriendNum() {
		return applicationFriendNum;
	}
	public void setApplicationFriendNum(int applicationFriendNum) {
		this.applicationFriendNum = applicationFriendNum;
	}
	
}

