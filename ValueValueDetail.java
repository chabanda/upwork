/**
 * 
 */
package up.fiz.model;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Chandana
 * 
 */
@Entity
@Table(name = "value_value_detail")
public class ValueValueDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7231817925582101015L;

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "value", column = @Column(name = "VALUE_ID")),
			@AttributeOverride(name = "valueDetailId", column = @Column(name = "VALUE_DETAIL_ID")) })
	private ValueValueDetailMapId valueValueDetailMapId;

	public ValueValueDetailMapId getValueValueDetailMapId() {
		return valueValueDetailMapId;
	}

	public void setValueValueDetailMapId(ValueValueDetailMapId valueValueDetailMapId) {
		this.valueValueDetailMapId = valueValueDetailMapId;
	}


}
