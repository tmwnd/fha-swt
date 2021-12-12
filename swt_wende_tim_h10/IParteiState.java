public interface IParteiState {
	public IParteiState parteilob();
	public IParteiState parteitadel();
	
	public interface IParteilob {
		public IParteiState parteilob();
	}
	
	public interface IParteitadel {
		public IParteiState parteitadel();
	}
}
