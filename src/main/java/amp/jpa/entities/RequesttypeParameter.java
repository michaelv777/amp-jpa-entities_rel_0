package amp.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the requesttype_parameters database table.
 * 
 */
@Entity
@Table(name="requesttype_parameters")
@NamedQuery(name="RequesttypeParameter.findAll", query="SELECT r FROM RequesttypeParameter r")
public class RequesttypeParameter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private long requesttypeparameterid;

	@Column(nullable=false)
	private BigInteger required;

	@Column(nullable=false)
	private BigInteger sequence;

	//bi-directional many-to-one association to Parameter
	@ManyToOne
	@JoinColumn(name="REQUESTTYPEPARAM2PARAMETER", nullable=false)
	private Parameter parameter;

	//bi-directional many-to-one association to RequesttypeM
	@ManyToOne
	@JoinColumn(name="REQUESTTYPEPARAM2REQUESTTYPE", nullable=false)
	private RequesttypeM requesttypeM;

	public RequesttypeParameter() {
	}

	public long getRequesttypeparameterid() {
		return this.requesttypeparameterid;
	}

	public void setRequesttypeparameterid(long requesttypeparameterid) {
		this.requesttypeparameterid = requesttypeparameterid;
	}

	public BigInteger getRequired() {
		return this.required;
	}

	public void setRequired(BigInteger required) {
		this.required = required;
	}

	public BigInteger getSequence() {
		return this.sequence;
	}

	public void setSequence(BigInteger sequence) {
		this.sequence = sequence;
	}

	public Parameter getParameter() {
		return this.parameter;
	}

	public void setParameter(Parameter parameter) {
		this.parameter = parameter;
	}

	public RequesttypeM getRequesttypeM() {
		return this.requesttypeM;
	}

	public void setRequesttypeM(RequesttypeM requesttypeM) {
		this.requesttypeM = requesttypeM;
	}

}