package matrix;

import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Path;
import org.neo4j.graphdb.traversal.Evaluators;
import org.neo4j.graphdb.traversal.TraversalDescription;
import org.neo4j.graphdb.traversal.Traverser;
import org.neo4j.kernel.EmbeddedGraphDatabase;
import org.neo4j.kernel.impl.traversal.TraversalDescriptionImpl;


public class MatrixGraphReader {

	public MatrixGraphReader() {
	
	}
	
	public void check1(EmbeddedGraphDatabase graphdb){
		
        Node neo = graphdb.getReferenceNode().getSingleRelationship(RelationshipEnum.MATRIX, Direction.OUTGOING).getEndNode();
		
        TraversalDescription td = new TraversalDescriptionImpl()
        	.breadthFirst()
        	.depthFirst()
        	.relationships(RelationshipEnum.KNOWS, Direction.OUTGOING)
        	.evaluator(Evaluators.excludeStartPosition());
        Traverser traverser = td.traverse(neo);
        
        int numberOfFriends = 0;
        String output = neo.getProperty( "name" ) + "'s friends:\n";
        
        for ( Path friendPath : traverser )
        {
            output += "At depth " + friendPath.length() + " => "
                      + friendPath.endNode()
                              .getProperty( "name" ) + "\n";
            numberOfFriends++;
        }
        output += "Number of friends found: " + numberOfFriends + "\n";
        System.out.println(output);        
	}
	
	public void check2(EmbeddedGraphDatabase graphdb){

		Node neo = graphdb.getReferenceNode().getSingleRelationship(RelationshipEnum.MATRIX, Direction.OUTGOING).getEndNode();
		
        TraversalDescription td = new TraversalDescriptionImpl()
        	.breadthFirst()
        	.depthFirst()
        	.relationships(RelationshipEnum.FIGHTS, Direction.OUTGOING)
        	.evaluator(Evaluators.excludeStartPosition());
        Traverser traverser = td.traverse(neo);
        
        int numberOfFriends = 0;
        String output = neo.getProperty( "name" ) + "'s enemies:\n";
        
        for ( Path friendPath : traverser )
        {
            output += "At depth " + friendPath.length() + " => "
                      + friendPath.endNode()
                              .getProperty( "name" ) + "\n";
            numberOfFriends++;
        }
        output += "Number of enemies found: " + numberOfFriends + "\n";
        System.out.println(output);        
		
	}
	
	public void check3(EmbeddedGraphDatabase graphdb){

        Node neo = graphdb.getReferenceNode().getSingleRelationship(RelationshipEnum.MATRIX, Direction.OUTGOING).getEndNode();
        Node morpheus = neo.getSingleRelationship(RelationshipEnum.KNOWS, Direction.OUTGOING).getEndNode();
        
		
        TraversalDescription td = new TraversalDescriptionImpl()
        	.breadthFirst()
        	.depthFirst()
        	.relationships(RelationshipEnum.KNOWS, Direction.BOTH)
        	.evaluator(Evaluators.excludeStartPosition());
        Traverser traverser = td.traverse(morpheus);
        
        int numberOfFriends = 0;
        String output = morpheus.getProperty( "name" ) + "'s friends:\n";
        
        for ( Path friendPath : traverser )
        {
            output += "At depth " + friendPath.length() + " => "
                      + friendPath.endNode()
                              .getProperty( "name" ) + "\n";
            numberOfFriends++;
        }
        output += "Number of friends found: " + numberOfFriends + "\n";
        System.out.println(output);        

	}
	
	public void check4(EmbeddedGraphDatabase graphdb){
		
        Node neo = graphdb.getReferenceNode().getSingleRelationship(RelationshipEnum.MATRIX, Direction.OUTGOING).getEndNode();
        
		
        TraversalDescription td = new TraversalDescriptionImpl()
        	.breadthFirst()
        	.depthFirst()
        	.relationships(RelationshipEnum.LOVES, Direction.INCOMING)
        	.evaluator(Evaluators.excludeStartPosition());
        Traverser traverser = td.traverse(neo);
        
        int numberOfFriends = 0;
        String output = neo.getProperty( "name" ) + "'s lovers:\n";
        
        for ( Path friendPath : traverser )
        {
            output += "At depth " + friendPath.length() + " => "
                      + friendPath.endNode()
                              .getProperty( "name" ) + "\n";
            numberOfFriends++;
        }
        output += "Number of lovers found: " + numberOfFriends + "\n";
        System.out.println(output);        
		
	}
	
	
	public void check5(EmbeddedGraphDatabase graphdb){
		
        Node neo = graphdb.getReferenceNode().getSingleRelationship(RelationshipEnum.MATRIX, Direction.OUTGOING).getEndNode();
        
        TraversalDescription td = new TraversalDescriptionImpl()
        	.breadthFirst()
        	.depthFirst()
        	.relationships(RelationshipEnum.KNOWS, Direction.BOTH)
        	.evaluator(Evaluators.excludeStartPosition());
        Traverser traverser = td.traverse(neo);
        
        int numberOfFriends = 0;
        String output = neo.getProperty( "name" ) + "Node:\n";
        
        for ( Path friendPath : traverser )
        {
            output += "contains at depth " + friendPath.length() + " => "
                      + friendPath.endNode()
                              .getProperty( "name" ) + "\n";
            numberOfFriends++;
        }
        output += "Number of lovers found: " + numberOfFriends + "\n";
        System.out.println(output);        
		
	}
	
}
