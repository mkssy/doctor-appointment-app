package com.doctor.api;

public class GenericDaoMaster {

	private String tableKey;
	private String nonDisplayColumn;
	private String displayColumn;
	private String tableName;
	private String coditionColumn1;
	private String coditionColumn2;

	public String getTableKey() {
		return tableKey;
	}

	public void setTableKey(String tableKey) {
		this.tableKey = tableKey;
	}

	public String getNonDisplayColumn() {
		return nonDisplayColumn;
	}

	public void setNonDisplayColumn(String nonDisplayColumn) {
		this.nonDisplayColumn = nonDisplayColumn;
	}

	public String getDisplayColumn() {
		return displayColumn;
	}

	public void setDisplayColumn(String displayColumn) {
		this.displayColumn = displayColumn;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getCoditionColumn1() {
		return coditionColumn1;
	}

	public void setCoditionColumn1(String coditionColumn1) {
		this.coditionColumn1 = coditionColumn1;
	}

	public String getCoditionColumn2() {
		return coditionColumn2;
	}

	public void setCoditionColumn2(String coditionColumn2) {
		this.coditionColumn2 = coditionColumn2;
	}

	@Override
	public String toString() {
		return "GenericDaoMaster [tableKey=" + tableKey + ", nonDisplayColumn=" + nonDisplayColumn + ", displayColumn="
				+ displayColumn + ", tableName=" + tableName + ", coditionColumn1=" + coditionColumn1
				+ ", coditionColumn2=" + coditionColumn2 + "]";
	}

}
