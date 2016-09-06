/**
 * 
 */
package up.fiz.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Chandana
 *
 */
@Embeddable
public class ValueValueDetailMapId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6750065008261388815L;
	
	@JoinColumn(name = "VALUE_ID", nullable = false)
	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	private Value value;
	
	@JoinColumn(name = "VALUE_DETAIL_ID", nullable = false)
	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	private ValueDetail valueDetail;

	public Value getValue() {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
	}

	public ValueDetail getValueDetail() {
		return valueDetail;
	}

	public void setValueDetail(ValueDetail valueDetail) {
		this.valueDetail = valueDetail;
	}

	
	
	
}
