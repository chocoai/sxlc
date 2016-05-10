
package cn.membermng.model; 

/***
* 我的好友
* 
* @author 李杰
* @since 
* @date 2016-5-5 下午7:39:16 
*
*/
public class Friends {
	
	private String				userName;			//好友名称
	private String				addTime;			//添加时间
	private long				memberIDApply;		//添加人ID
	private long				memberIDReceive;	//被添加人ID
	
	private long         	friendId;              		//好友的ID
	
	private int 				statu;						//申请状态 -1	已拒绝 0	申请中 1	已同意
	private int 				type;							//0想加我的   1我想加的

	public int getStatu() {
		return statu;
	}

	public void setStatu(int statu) {
		this.statu = statu;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public long getMemberIDApply() {
		return memberIDApply;
	}

	public void setMemberIDApply(long memberIDApply) {
		this.memberIDApply = memberIDApply;
	}

	public long getMemberIDReceive() {
		return memberIDReceive;
	}

	public void setMemberIDReceive(long memberIDReceive) {
		this.memberIDReceive = memberIDReceive;
	}

	public long getFriendId() {
		return friendId;
	}

	public void setFriendId(long friendId) {
		this.friendId = friendId;
	}
	
}

