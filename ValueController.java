package up.fiz.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import up.fiz.model.DataTable;
import up.fiz.model.Value;
import up.fiz.model.ValueDetail;
import up.fiz.service.ValueService;

/**
 * @author chandana_techsys
 */

@Controller
@Scope("view")
public class ValueController {

	@Autowired
	private ValueService valueService;
	private static final Log LOG = LogFactory.getLog(ValueController.class);

	private List<DataTable> dataTableList;
	private DataTable dataTable;

	private Map<Long, String> valueList;
	private Value value;

	private Map<Long, String> valueDetailList;
	private ValueDetail valueDetail;

	public ValueController() {
		value = new Value();
		valueDetail = new ValueDetail();
		dataTableList = new LinkedList<DataTable>();
	}

	@PostConstruct
	private void initializeVlaues() {
		setValueList(getValues());
	}

	private Map<Long, String> getValues() {
		Map<Long, String> valueList = new LinkedHashMap<Long, String>();
		try {
			List<Value> values = valueService.getAllValuess();

			for (Value value : values) {
				valueList.put(value.getValueId(), value.getValue());
			}

		} catch (Exception e) {
			FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cannot Load Values!", "");
			FacesContext.getCurrentInstance().addMessage(null, error);
		}
		return valueList;
	}

	public void onValueChange() {
		valueDetailList = new LinkedHashMap<Long, String>();
		if (value.getValueId() != 0) {
			List<ValueDetail> valueDetails = valueService.getValueDetailsByValueId(value.getValueId());
			for (ValueDetail valueDetail : valueDetails) {
				valueDetailList.put(valueDetail.getValueDetailId(), valueDetail.getData());
			}
		} else {
			FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cannot Load Value details!", "");
			FacesContext.getCurrentInstance().addMessage(null, error);
		}
	}

	public void deleteValue() {
		try {
			if (null != dataTable) {
				valueService.deleteDataTableRow(dataTable);
				Iterator<DataTable> it = dataTableList.iterator();
				while (it.hasNext()) {
					DataTable dt = it.next();
					if (dt.getDataTableId() == dataTable.getDataTableId()) {
						it.remove();
						break;
					}
				}
			} else {
				FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cannot add Value details!", "");
				FacesContext.getCurrentInstance().addMessage(null, error);
			}
		} catch (Exception e) {
			FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cannot Delete from grid!", "");
			FacesContext.getCurrentInstance().addMessage(null, error);
		}
	}

	public void addToGrid() {
		try {
			if ((value.getValueId() != 0) && (valueDetail.getValueDetailId() != 0)) {
				Value valueTmp = valueService.getValueByValueId(value.getValueId());
				ValueDetail valueDetailTmp = valueService.getValueDetailByValueDetailId(valueDetail.getValueDetailId());
				DataTable dataTable = new DataTable();
				dataTable.setValueId(valueTmp.getValueId());
				dataTable.setValue(valueTmp.getValue());
				dataTable.setValueData(valueTmp.getValueData());
				dataTable.setValueDetailId(valueDetailTmp.getValueDetailId());
				dataTable.setData(valueDetailTmp.getData());
				dataTable = valueService.saveDataTableRec(dataTable);
				dataTableList.add(dataTable);
			} else {
				FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cannot add Value details!", "");
				FacesContext.getCurrentInstance().addMessage(null, error);
			}
		} catch (Exception e) {
			FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cannot Add to grid!", "");
			FacesContext.getCurrentInstance().addMessage(null, error);
		}
	}

	public void reset() {
		dataTableList = new LinkedList<DataTable>();
	}

	public List<DataTable> getDataTableList() {
		return dataTableList;
	}

	public void setDataTableList(List<DataTable> dataTableList) {
		this.dataTableList = dataTableList;
	}

	public DataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(DataTable dataTable) {
		this.dataTable = dataTable;
	}

	public Map<Long, String> getValueList() {
		return valueList;
	}

	public void setValueList(Map<Long, String> valueList) {
		this.valueList = valueList;
	}

	public Value getValue() {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
	}

	public Map<Long, String> getValueDetailList() {
		return valueDetailList;
	}

	public void setValueDetailList(Map<Long, String> valueDetailList) {
		this.valueDetailList = valueDetailList;
	}

	public ValueDetail getValueDetail() {
		return valueDetail;
	}

	public void setValueDetail(ValueDetail valueDetail) {
		this.valueDetail = valueDetail;
	}

}
