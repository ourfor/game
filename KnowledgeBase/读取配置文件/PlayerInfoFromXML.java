package game.refactoring.finished.r3.config;

public class PlayerInfoFromXML implements IPlayerInfo {
	private XMLUtil xmlUtil = new XMLUtil();
	
	@Override
	public String[] getPlayerRoles() {
		// TODO Auto-generated method stub
		return xmlUtil.getByNames("roleNames");
	}

	@Override
	public String[] getPlayerIDs() {
		// TODO Auto-generated method stub
		return xmlUtil.getByNames("playerIDs");
	}

}
