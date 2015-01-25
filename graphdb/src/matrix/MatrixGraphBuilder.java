package matrix;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.kernel.EmbeddedGraphDatabase;

public class MatrixGraphBuilder {

	public MatrixGraphBuilder() {
		// TODO Auto-generated constructor stub
	}

	private EmbeddedGraphDatabase graph = null;
	
	public EmbeddedGraphDatabase build(String filename){
		
		this.graph = new EmbeddedGraphDatabase(filename);
		Transaction tx = this.graph.beginTx();
		try{	
			Node neo = this.graph.createNode();
			neo.setProperty("name", "Neo");
			neo.setProperty("nickname", "CopperTop");
            Node referenceNode = this.graph.getReferenceNode();
            referenceNode.createRelationshipTo( neo, RelationshipEnum.MATRIX );
			Node morpheus = this.graph.createNode();
			morpheus.setProperty("name", "Morpheus");
			neo.createRelationshipTo(morpheus, RelationshipEnum.KNOWS);
			Node trinity = this.graph.createNode();
			trinity.setProperty("name", "Trinity");
			morpheus.createRelationshipTo(trinity, RelationshipEnum.KNOWS);
			trinity.createRelationshipTo(neo, RelationshipEnum.LOVES);
			Node cypher = this.graph.createNode();
			cypher.setProperty("name", "Cypher");
			morpheus.createRelationshipTo(cypher, RelationshipEnum.KNOWS);
			Node mrSmith = this.graph.createNode();
			mrSmith.setProperty("name", "Mr. Smith");
			morpheus.createRelationshipTo(mrSmith, RelationshipEnum.FIGHTS);
			neo.createRelationshipTo(mrSmith, RelationshipEnum.FIGHTS);
			
		
			tx.success();
			System.out.println("Successfully created graph db.");
		} 
		catch (Exception e) {
			System.out.println("Committing transaction threw an Exception.");
			tx.failure();
		} 
		finally {
			tx.finish();
		}
		
		System.out.println("returning graph db.");
		return this.graph;
	}
	
	
	
	public void destroy(){
		this.graph.shutdown();
	}
}
