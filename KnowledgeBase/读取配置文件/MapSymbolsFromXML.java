package game.refactoring.finished.r3.config;

public class MapSymbolsFromXML implements IMapSymbols {
	private XMLUtil xmlUtil = new XMLUtil();
	
	@Override
	public String getPlayer1() {
		// TODO Auto-generated method stub
		return xmlUtil.getByName("player1");
	}

	@Override
	public String getPlayer2() {
		// TODO Auto-generated method stub
		return xmlUtil.getByName("player2");
	}

	@Override
	public String getStartPoint() {
		// TODO Auto-generated method stub
		return xmlUtil.getByName("startPoint");
	}

	@Override
	public String getEndPoint() {
		// TODO Auto-generated method stub
		return xmlUtil.getByName("endPoint");
	}
	
	@Override
	public String getLuckyTurn() {
		// TODO Auto-generated method stub
		return xmlUtil.getByName("luckyTurn");
	}

	@Override
	public String getLandMine() {
		// TODO Auto-generated method stub
		return xmlUtil.getByName("landMine");
	}

	@Override
	public String getPause() {
		// TODO Auto-generated method stub
		return xmlUtil.getByName("pause");
	}

	@Override
	public String getTimeTunnel() {
		// TODO Auto-generated method stub
		return xmlUtil.getByName("timeTunnel");
	}

	@Override
	public String getCommon() {
		// TODO Auto-generated method stub
		return xmlUtil.getByName("common");
	}

}
