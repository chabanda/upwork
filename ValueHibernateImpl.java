package up.fiz.persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import up.fiz.model.DataTable;
import up.fiz.model.Value;
import up.fiz.model.ValueDetail;
/**
 * @author eranda_jkcs
 *
 */
@Repository
@Transactional
public class ValueHibernateImpl {
	@Autowired
	private SessionFactory sessionFactory;	

	
	public List<Value> getAllValuess() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("From Value").getResultList();
	}
	
	public List<ValueDetail> getValueDetailsByValueId(Long valueId) {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("select vvd.valueValueDetailMapId.valueDetail From ValueValueDetail vvd where vvd.valueValueDetailMapId.value.valueId=:valueId");
		return q.setParameter("valueId", valueId).getResultList();
	}
	
	public Value getValueByValueId(Long valueId) {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("From Value v where v.valueId=:valueId");
		return (Value)q.setParameter("valueId", valueId).getSingleResult();
	}
	
	public ValueDetail getValueDetailByValueDetailId(Long valueDetailId) {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("From ValueDetail vd where vd.valueDetailId=:valueDetailId");
		return (ValueDetail)q.setParameter("valueDetailId", valueDetailId).getSingleResult();
	}
	
	public DataTable saveDataTableRec(DataTable dt) {
		Session session = sessionFactory.getCurrentSession();
		session.save(dt);
		return dt;
	}
	
	public void deleteDataTableRow(DataTable dt) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(dt);
	}

}
