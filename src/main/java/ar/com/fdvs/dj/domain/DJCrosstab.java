package ar.com.fdvs.dj.domain;

import java.util.ArrayList;
import java.util.List;

import ar.com.fdvs.dj.test.CalculatedColumnReportTest;

public class DJCrosstab {
	
	private List rows = new ArrayList();
	private List columns = new ArrayList();
	
	private boolean showColumnGroupTotals;
	private boolean showRowGroupTotals;
	
	private ColumnProperty measure;
	private ColumnsGroupVariableOperation operation;
	
	private int height;
	private int width;
	
	
	public boolean isShowColumnGroupTotals() {
		return showColumnGroupTotals;
	}
	public void setShowColumnGroupTotals(boolean showColumnGroupTotals) {
		this.showColumnGroupTotals = showColumnGroupTotals;
	}
	public boolean isShowRowGroupTotals() {
		return showRowGroupTotals;
	}
	public void setShowRowGroupTotals(boolean showRowGroupTotals) {
		this.showRowGroupTotals = showRowGroupTotals;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	public List getColumns() {
		return columns;
	}
	public void setColumns(List columns) {
		this.columns = columns;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public ColumnProperty getMeasure() {
		return measure;
	}
	public void setMeasure(ColumnProperty measure) {
		this.measure = measure;
	}
	public ColumnsGroupVariableOperation getOperation() {
		return operation;
	}
	public void setOperation(ColumnsGroupVariableOperation operation) {
		this.operation = operation;
	}

}