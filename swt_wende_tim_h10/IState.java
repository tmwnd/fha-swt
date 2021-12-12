public interface IState {
	public IState erwischt();
	public IParteiState getParteiState();
	public void setParteiState(IParteiState parteiState);
	public IWirtschaftsState getWirtschaftsState();
	public void setWirtschaftsState(IWirtschaftsState wirtschaftsState);
	
	public State parteilob();
	public State parteitadel();
	
	public State wirtschaftslob();
	public State wirtschaftskritik();
	
	public interface IErwischt {
		public IState erwischt();
	}
}
