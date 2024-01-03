
public class Dot{
	private Coordinate start;
	private Coordinate end;
	private Coordinate midset;
//	private int counts;
//	private String set;
	
	
	public Dot(String start, String end/*, int counts, String set*/) {
		String[] startArray = start.split(", ");
		String[] endArray = end.split(", ");

		this.start = new Coordinate(startArray[0], startArray[1]);
		this.end = new Coordinate(endArray[0], endArray[1]);
		double stsDist = this.end.getSts() - this.start.getSts();
		double ftbDist = this.end.getFtb() - this.start.getFtb();
		this.midset = new Coordinate(this.start.getSts() + (stsDist / 2), this.start.getFtb() + (ftbDist / 2));		
//		this.counts = counts;
//		this.set = set;
	}

	@Override
	public String toString() {
		return /*"SET " + this.set +*/ "\nStart:  " + this.start + "\nEnd:    " + this.end + "\nMidset: " + this.midset /*+ "\nCounts: " + this.counts*/;  
	}
}
