
public class clock implements Runnable{
	private Thread t;
	private int ticks;
	public void start(){
		t=new Thread(this);
		t.start();
	}
	public int getTicks(){
		return this.ticks;
	}
	public void run(){
		ticks=0;	
		try{
			while (true){
				Thread.sleep(50);
				//System.out.println("current ticks="+ticks);
				game.panel.update();
				ticks++;
			}
		}catch (InterruptedException e){
			System.exit(0);
		}
	}
}
