package up.fiz.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="DATA_TABLE")
public class DataTable implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(allocationSize = 1, name = "s_data_table", sequenceName = "SEQ_DATA_TABLE")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "s_data_table")
	@Column(name ="DATA_TABLE_ID")
	private Long dataTableId;
	@Column(name ="VALUE_ID")
	private Long valueId;
	@Column(name ="VALUE")
	private String value;
	@Column(name ="VALUE_DATA")
	private String valueData;
	@Column(name ="VALUE_DETAIL_ID")
	private Long valueDetailId;
	@Column(name ="DATA")
	private String data;
	
	public Long getDataTableId() {
		return dataTableId;
	}
	public void setDataTableId(Long dataTableId) {
		this.dataTableId = dataTableId;
	}
	public Long getValueId() {
		return valueId;
	}
	public void setValueId(Long valueId) {
		this.valueId = valueId;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getValueData() {
		return valueData;
	}
	public void setValueData(String valueData) {
		this.valueData = valueData;
	}
	public Long getValueDetailId() {
		return valueDetailId;
	}
	public void setValueDetailId(Long valueDetailId) {
		this.valueDetailId = valueDetailId;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	
	
}
