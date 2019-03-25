class Builder {

	private Integer v1, v2, v3, v4, v5;

	private Builder(Integer v1, Integer v2, Integer v3, Integer v4, Integer v5) {
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
		this.v4 = v4;
		this.v5 = v5;
	}

	static class BuilderBuilder {

		private Integer v1, v2, v3, v4, v5;

		BuilderBuilder() {
			this.v1 = 0;
			this.v2 = 0;
			this.v3 = 0;
			this.v4 = 0;
			this.v5 = 0;
		}

		void setV1(Integer val) {
			this.v1 = val;
		}

		void setV2(Integer val) {
			this.v2 = val;
		}

		void setV3(Integer val) {
			this.v3 = val;
		}

		void setV4(Integer val) {
			this.v4 = val;
		}

		void setV5(Integer val) {
			this.v5 = val;
		}

		Builder build() {
			return new Builder(this.v1, this.v2, this.v3, this.v4, this.v5);
		}

	}

	public String toString() {
		return this.v1 + " " + this.v2 + " " + this.v3 + " " + this.v4 + " " + this.v5;
	}

	public static void main(String[] args) {
		Builder.BuilderBuilder bb = new Builder.BuilderBuilder();
		bb.setV2(1);
		bb.setV3(2);
		bb.setV5(3);

		System.out.println(bb.build());
	}

}
