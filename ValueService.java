package up.fiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import up.fiz.model.DataTable;
import up.fiz.model.Value;
import up.fiz.model.ValueDetail;
import up.fiz.persistence.ValueHibernateImpl;

@Service
public class ValueService {
	
	@Autowired
	private ValueHibernateImpl valueHibernateImpl;
	
	public List<Value> getAllValuess() {
		return valueHibernateImpl.getAllValuess();
	}
	
	public List<ValueDetail> getValueDetailsByValueId(Long valueId) {
		return valueHibernateImpl.getValueDetailsByValueId(valueId);
	}
	
	public Value getValueByValueId(Long valueId) {
		return valueHibernateImpl.getValueByValueId(valueId);
	}
	
	public ValueDetail getValueDetailByValueDetailId(Long valueDetailId) {
		return valueHibernateImpl.getValueDetailByValueDetailId(valueDetailId);
	}
	
	public DataTable saveDataTableRec(DataTable dt) {
		return valueHibernateImpl.saveDataTableRec(dt);
	}
	
	public void deleteDataTableRow(DataTable dt) {
		valueHibernateImpl.deleteDataTableRow(dt);
	}
}
