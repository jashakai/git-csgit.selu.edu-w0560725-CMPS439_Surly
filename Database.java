
import java.util.LinkedList;
import java.util.ListIterator;

// Represents a database of relations.
//
// All relations are stored in a linked list of relations.
//
public class Database
{
    LinkedList<Relation> relations = new LinkedList<>();

    public void insertRelation(Relation relation)
    {
        if (!relations.contains(relation))
        {
            relations.add(relation);
        }
        else
        {
            //This looks weird, but its surly spec, it destroys old instance of the
            //relation and adds a new one.
            relation.tuples.clear();
            relations.remove(relation);
            relations.add(relation);
        }
    }

    /*
        findRelation is used to find the index of a relation based on its name
        in order to delete, destroy, or insert.
    */

    public int findRelation(String name)
    {
        // return a value of -1 to indicate that the relation was not found
        int index = -1;

        for(int i = 0 ; i < relations.size(); ++i)
        {
            if (name.equals(relations.get(i).name))
            {
                index = i;
            }
        }
        return index;
    }

    public Relation getRelation(String name)
    {
        for (Relation relation : relations)
        {
            if (relation.name.equals(name))
            {
                return relation;
            }
        }

        // relation not found
        return null;
    }

    public void destroyRelation(String name)
    {
        int index = findRelation(name);
        relations.get(index).tuples.clear();
        relations.remove(index);
    }

    public void deleteRelationTuples(String name)
    {
        int index = findRelation(name);
        relations.get(index).tuples.clear();
    }

    public void printDB()
    {
        ListIterator<Relation> relationsIt = relations.listIterator();

        while(relationsIt.hasNext())
        {
            relationsIt.next().printRelation();
        }
    }

    public void printRelation(String name)
    {
        int index = findRelation(name);
        if (index == -1)
        {
            System.out.println("Relation not found: " + name);
        }
        else
        {
            relations.get(index).printRelation();
        }
    }
}
