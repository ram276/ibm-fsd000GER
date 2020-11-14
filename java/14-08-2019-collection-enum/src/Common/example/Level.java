package Common.example;

public enum Level {
    HIGH(3),
    MEDIUM(2),
    LOW(1);
	public int getLevelCode() {
		return levelCode;
	}

	public void setLevelCode(int levelCode) {
		this.levelCode = levelCode;
	}

	private int levelCode;

	private Level(int levelCode) {
		this.levelCode = levelCode;
	}

	private Level() {
	}
	
}
