public interface IWirtschaftsState {
	public IWirtschaftsState wirtschaftslob();
	public IWirtschaftsState wirtschaftskritik();
	
	public interface IWirtschaftslob {
		public IWirtschaftsState wirtschaftslob();
	}
	
	public interface IWirtschaftskritik {
		public IWirtschaftsState wirtschaftskritik();
	}
}
