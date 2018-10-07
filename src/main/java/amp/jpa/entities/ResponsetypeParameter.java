package amp.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the responsetype_parameters database table.
 * 
 */
@Entity
@Table(name="responsetype_parameters")
@NamedQuery(name="ResponsetypeParameter.findAll", query="SELECT r FROM ResponsetypeParameter r")
public class ResponsetypeParameter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private long responsetypeparameterid;

	@Column(nullable=false)
	private BigInteger required;

	@Column(nullable=false)
	private BigInteger sequence;

	//bi-directional many-to-one association to Parameter
	@ManyToOne
	@JoinColumn(name="RESPTYPEPARAM2PARAMETER", nullable=false)
	private Parameter parameter;

	//bi-directional many-to-one association to ResponsetypeM
	@ManyToOne
	@JoinColumn(name="RESPTYPEPARAM2RESPONSETYPE", nullable=false)
	private ResponsetypeM responsetypeM;

	public ResponsetypeParameter() {
	}

	public long getResponsetypeparameterid() {
		return this.responsetypeparameterid;
	}

	public void setResponsetypeparameterid(long responsetypeparameterid) {
		this.responsetypeparameterid = responsetypeparameterid;
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

	public ResponsetypeM getResponsetypeM() {
		return this.responsetypeM;
	}

	public void setResponsetypeM(ResponsetypeM responsetypeM) {
		this.responsetypeM = responsetypeM;
	}

}