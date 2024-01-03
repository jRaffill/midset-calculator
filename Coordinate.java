
public class Coordinate {
	private String[] sideToSide;
	private String[] frontToBack;
	private double sts;
	private double ftb;
	
	public Coordinate(String sideToSide, String frontToBack) {
		// split the strings into arrays for easy parsing
		this.sideToSide = sideToSide.split(" ");
		this.frontToBack = frontToBack.split(" ");

		// calculate side to side
		if (this.sideToSide[0].equals("S1")) { 
			// if the dot is on side one
			// calculate the yards
			this.sts = Double.parseDouble(this.sideToSide[3]);
			// convert yards to steps (8 to 5 ratio) 
			this.sts = toSteps(this.sts);
			// add or subtract the number of steps from the yardline (depending on in or out)
			if (this.sideToSide[2].equals("in")) {
				this.sts += Double.parseDouble(this.sideToSide[1]);
			}
			else {
				this.sts -= Double.parseDouble(this.sideToSide[1]);
			}
		} else { 
			// if the dot is on side two
			// calculate the yards (subtract from total of side 2, which is 100)
			this.sts = 100 - Double.parseDouble(this.sideToSide[3]);
			// convert yards to steps (8 to 5 ratio) 
			this.sts = toSteps(this.sts);
			// add or subtract the number of steps from the yardline (depending on in our out)
			if (this.sideToSide[2].equals("in")) {
				this.sts -= Double.parseDouble(this.sideToSide[1]);
			}
			else {
				this.sts += Double.parseDouble(this.sideToSide[1]);
			}
		}
		
		// calculate front to back
		if (this.frontToBack[2].equals("FS")) {
			this.ftb = 0;
		} else if (this.frontToBack[2].equals("FH")) {
			this.ftb = 28;
		} else if (this.frontToBack[2].equals("BH")) {
			this.ftb = 56;
		} else {
			this.ftb = 84;
		}
		if (this.frontToBack[1].equals("front")) {
			this.ftb -= Double.parseDouble(this.frontToBack[0]);
		} else {
			this.ftb += Double.parseDouble(this.frontToBack[0]);
		}
	}
	
	public Coordinate(double sts, double ftb) {
		this.sts = sts;
		this.ftb = ftb;
		this.sideToSide = new String[4];
		this.frontToBack = new String[3];
		// calculate side to side
		double yardline; 
		double yards = toYards(this.sts);
		if (yards < 50) {
			// if on side one
			this.sideToSide[0] = "S1";
			// convert to yards
			yards = toYards(this.sts);
			// round to nearest multiple of five for yardline
		} else {
			// if on side two
			this.sideToSide[0] = "S2";
			// convert to yards from the other side
			yards = 100 - yards;
			// round to nearest multiple of five for yardline
		}
		yardline = (Math.round(yards / 5) * 5);
		// get number of steps inside or outside of yardline
		if (yardline < yards) {
			this.sideToSide[1] = String.valueOf(toSteps(yards) - toSteps(yardline));
			this.sideToSide[2] = "in";
		} else {
			this.sideToSide[1] = String.valueOf(toSteps(yardline) - toSteps(yards));
			this.sideToSide[2] = "out";
		}
		// save yardline
		this.sideToSide[3] = String.valueOf((int)(yardline));
		
		// calculate front to back
		// get closest hash value (in steps)
		int hash = (int) Math.round(this.ftb / 28) * 28;
		if (hash == 0) {
			this.frontToBack[2] = "FS";
		} else if (hash == 28) {
			this.frontToBack[2] = "FH";
		} else if (hash == 56) {
			this.frontToBack[2] = "BH";
		} else {
			this.frontToBack[2] = "BS";
		}
		// get distance from closest hash value
		double distance = hash - this.ftb;
		if (distance > 0) {
			this.frontToBack[1] = "front";
		} else {
			this.frontToBack[1] = "back";
		}
		this.frontToBack[0] = String.valueOf(Math.abs(distance));
	}
	
	private double toYards(double steps) {
		steps /= 8;
		steps *= 5;
		return steps;
	}
	
	private double toSteps (double yards) {
		yards /= 5;
		yards *= 8;
		return yards;
	}
	
	public double getSts() {
		return this.sts;
	}
	
	public double getFtb() {
		return this.ftb;
	}
	
	public String toString() {
		return String.format("%-20s %s", String.join(" ", sideToSide), String.join(" ", frontToBack));
	}
}