package amp.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.Set;


/**
 * The persistent class for the parametertype_m database table.
 * 
 */
@Entity
@Table(name="parametertype_m")
@NamedQuery(name="ParametertypeM.findAll", query="SELECT p FROM ParametertypeM p")
public class ParametertypeM implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private long parametertypeid;

	@Column(nullable=false, length=100)
	private String description;

	@Column(nullable=false)
	private BigInteger direction;

	//bi-directional many-to-one association to Parameter
	@OneToMany(mappedBy="parametertypeM")
	private Set<Parameter> parameters;

	public ParametertypeM() {
	}

	public long getParametertypeid() {
		return this.parametertypeid;
	}

	public void setParametertypeid(long parametertypeid) {
		this.parametertypeid = parametertypeid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigInteger getDirection() {
		return this.direction;
	}

	public void setDirection(BigInteger direction) {
		this.direction = direction;
	}

	public Set<Parameter> getParameters() {
		return this.parameters;
	}

	public void setParameters(Set<Parameter> parameters) {
		this.parameters = parameters;
	}

	public Parameter addParameter(Parameter parameter) {
		getParameters().add(parameter);
		parameter.setParametertypeM(this);

		return parameter;
	}

	public Parameter removeParameter(Parameter parameter) {
		getParameters().remove(parameter);
		parameter.setParametertypeM(null);

		return parameter;
	}

}