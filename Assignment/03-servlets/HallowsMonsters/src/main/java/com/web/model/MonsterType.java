package com.web.model;

public class MonsterType {
		private int id;
		private String type;
		private boolean furry;
		private boolean paws;
		
		
		public MonsterType(int id, String type, boolean furry, boolean paws) {
			super();
			this.id = id;
			this.type = type;
			this.furry = furry;
			this.paws = paws;
		}
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public MonsterType() {
			super();
		}

		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public boolean isFurry() {
			return furry;
		}
		public void setFurry(boolean furry) {
			this.furry = furry;
		}
		public boolean isPaws() {
			return paws;
		}
		public void setPaws(boolean paws) {
			this.paws = paws;
		}

		@Override
		public String toString() {
			return "MonsterType [type=" + type + ", furry=" + furry + ", paws=" + paws + "]";
		}
		
		
		
}
