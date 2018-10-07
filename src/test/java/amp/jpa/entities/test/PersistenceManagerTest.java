/**
 * 
 */
package amp.jpa.entities.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Test;

import amp.jpa.entities.manager.PersistenceManager;
import junit.framework.TestCase;

/**
 * @author MVEKSLER
 *
 */
public class PersistenceManagerTest extends TestCase 
{

	protected EntityManager entityManager = null;
	
	protected PersistenceManager pm = null;
	
	protected EntityManagerFactory fact = null;
	
	//protected String dbServerURI = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	protected String dbServerURI = "jdbc:mysql://127.0.0.1:3306/allmarket";
	/**
	 * @param name
	 */
	public PersistenceManagerTest(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception 
	{
		super.setUp();
		
		boolean cRes = true;
		
		try
		{
			if ( cRes )
			{		
				this.pm = PersistenceManager.getInstance();
				
				if ( null == this.pm )
				{
					cRes = false;
				}
			}
			
			if ( cRes )
			{
				cRes = this.pm.configure(this.dbServerURI, "allmarket", "allmarket", false);
			}
		
			if ( cRes )
			{
				this.fact = pm.getEntityManagerFactory();
				
				if ( null == this.fact )
				{
					cRes = false;
				}
			}
			
			if ( cRes )
			{
				this.entityManager = fact.createEntityManager();
				
				if ( null == this.entityManager )
				{
					cRes = false;
				}
			}
			
			if ( !cRes )
			{
				fail("cRes = false");
			}
		}
		catch( Exception e )
		{
			cRes = false;
			
			fail("cRes = false");
		}
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception 
	{
		super.tearDown();
		
		try
		{
			if (this.fact != null )
			{
				this.fact.close();
			}
			
			if (this.pm != null )
			{
				this.pm.close();
			}
		}
		catch( Exception e)
		{
			
		}
	}
	
	@Test
	public final void testNodepersistence() 
	{
		try
		{
			
		}
		catch( Exception e)
		{
			
		}
	}

	
}
