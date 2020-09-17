package testmatrix;

import org.neo4j.graphdb.*;
import org.neo4j.graphdb.traversal.TraversalDescription;
import org.neo4j.graphdb.traversal.Traverser;
import org.neo4j.kernel.EmbeddedGraphDatabase;
import org.neo4j.kernel.Traversal;
import org.neo4j.kernel.Uniqueness;

public class MatrixTest
{

    private GraphDatabaseService graphdb;
    private Node neo;
    private Node architect;
    RelationshipType KNOWS = DynamicRelationshipType.withName( "KNOWS" );
    final RelationshipType LOVES = DynamicRelationshipType.withName( "LOVES" );
    RelationshipType MATRIX = DynamicRelationshipType.withName( "MATRIX" );
    RelationshipType HAS_CODED = DynamicRelationshipType.withName( "HAS_CODED" );
    //private IndexService index;

    //@Test
    public void buildMatrix()
    {

        graphdb = new EmbeddedGraphDatabase( "target/neo4j" );
//        index = new LuceneIndexService( graphdb );
//        Transaction tx = graphdb.beginTx();
//        try
//        {
//            Node root = graphdb.getReferenceNode();
//            // conenct Neo with the reference node in order to have a konw start
//            // node.
//            // not necessary, but convenient.
//            neo = createAndConnectNode( "Neo", root, MATRIX );
//            Node morpheus = createAndConnectNode( "Morpheus", neo, KNOWS );
//            Node cypher = createAndConnectNode( "Cypher", morpheus, KNOWS );
//            Node trinity = createAndConnectNode( "Trinity", morpheus, KNOWS );
//            Node agentSmith = createAndConnectNode( "Agent Smith", cypher,
//                    KNOWS );
//            architect = createAndConnectNode( "The Architect", agentSmith,
//                    HAS_CODED );
//            // Trinity loves Neo. He doesn't konw (yet).
//            trinity.createRelationshipTo( neo, LOVES );
//            tx.success();
//        }
//        catch ( Exception e )
//        {
//            tx.failure();
//        }
//        finally
//        {
//            tx.finish();
//        }
        Node root = graphdb.getReferenceNode();
        Node neo = graphdb.getReferenceNode().getSingleRelationship( MATRIX,
                Direction.BOTH ).getOtherNode( root );

        for ( Relationship rel : neo.getRelationships( KNOWS ) )
        {
            Node friend = rel.getOtherNode( neo );
            System.out.println( friend.getProperty( "name" ) );
        }

//        Traverser friends = neo.traverse( Order.BREADTH_FIRST,
//                StopEvaluator.DEPTH_ONE,
//                ReturnableEvaluator.ALL_BUT_START_NODE, KNOWS, Direction.BOTH );
//        for ( Node friend : friends )
//        {
//            System.out.println( friend.getProperty( "name" ) );
//        }
//        StopEvaluator twoSteps = new StopEvaluator()
//        {
//            @Override
//            public boolean isStopNode( TraversalPosition position )
//            {
//                return position.depth() == 2;
//            }
//        };
//        ReturnableEvaluator nodesAtDepthTwo = new ReturnableEvaluator()
//        {
//            @Override
//            public boolean isReturnableNode( TraversalPosition position )
//            {
//                return position.depth() == 2;
//            }
//        };
//        Traverser friendsOfFriends = neo.traverse( Order.BREADTH_FIRST,
//                twoSteps, nodesAtDepthTwo, KNOWS, Direction.BOTH );
//        for ( Node friend : friendsOfFriends )
//        {
//            System.out.println( friend.getProperty( "name" ) );
//        }

//        ReturnableEvaluator findLove = new ReturnableEvaluator()
//        {
//            @Override
//            public boolean isReturnableNode( TraversalPosition position )
//            {
//                return position.currentNode().hasRelationship( LOVES,
//                        Direction.OUTGOING );
//            }
//        };
//        ArrayList<Object> types = new ArrayList<Object>();
        // collect all relationship types use in the graph and directions for
        // them
        // for ( RelationshipType type : graphdb.getRelationshipTypes() )
        // {
        // types.add( type );
        // types.add( Direction.BOTH );
        // }
        // Traverser inLove = architect.traverse( Order.BREADTH_FIRST,
        // StopEvaluator.END_OF_GRAPH, findLove, types.toArray() );
        // for ( Node lover : inLove )
        // {
        // System.out.println( lover.getProperty( "name" ) );
        // }

        TraversalDescription neosNetwork = Traversal.description().
            relationships( KNOWS );
        System.out.println("short traversal");
        Traverser traverser = neosNetwork.traverse( neo );
        for ( Path friend : traverser )
        {
            System.out.println( "at depth " + friend.length() + " " +friend.endNode().getProperty( "name" ) );
        }
        neosNetwork = Traversal.description().
        //filter( Traversal.returnAll() ).
        expand( Traversal.expanderForTypes( KNOWS, Direction.BOTH ) ).
        order( Traversal.preorderBreadthFirst() ).
        uniqueness( Uniqueness.NODE_GLOBAL );
        //prune( PruneEvaluator.NONE );
        //System.out.println("long traversal");
        for ( Path friend : traverser )
        {
            System.out.println( "at depth " + friend.length() + " " + friend.endNode().getProperty( "name" ) );
        }

/*
        TraversalDescription td = new TraversalDescriptionImpl().
          filter( new Predicate<Path>() {
            @Override
            public boolean accept( Path item ) {
                return item.endNode().hasRelationship( LOVES,
                        Direction.OUTGOING );
            }
          } );
        for ( Node lover : td.traverse( neo ).nodes() ) {
            System.out.println( "lover: "+ lover.getProperty( "name" ) );
        }
        
        graphdb.shutdown();
*/
    }

    private Node createAndConnectNode( String name, Node otherNode,
            RelationshipType relatiohshipType )
    {
        Node node = graphdb.createNode();
        node.setProperty( "name", name );
        node.createRelationshipTo( otherNode, relatiohshipType );
        //index.index( node, "name", name );
        return node;
    }
}