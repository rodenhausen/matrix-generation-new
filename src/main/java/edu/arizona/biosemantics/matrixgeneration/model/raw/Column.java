package edu.arizona.biosemantics.matrixgeneration.model.raw;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Column {

	private ColumnHead columnHead;
	private Map<RowHead, CellValue> cellValues = new HashMap<RowHead, CellValue>();
		
	public Column(ColumnHead columnHead, Map<RowHead, CellValue> cellValues) {
		super();
		this.columnHead = columnHead;
		this.cellValues = cellValues;
	}
	public ColumnHead getColumnHead() {
		return columnHead;
	}
	public void setColumnHead(ColumnHead columnHead) {
		this.columnHead = columnHead;
	}
	public Map<RowHead, CellValue> getCellValues() {
		return cellValues;
	}
	public void setCellValues(Map<RowHead, CellValue> cellValues) {
		this.cellValues = cellValues;
	}
	
	
	

}