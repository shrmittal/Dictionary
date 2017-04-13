package com.example.android.dictionary;

/**
 * Created by SHREYA on 4/1/2017.
 */
public class NodeClass {

    int ALPHABET_SIZE=26;
    int CASE='a';
    NodeClass parent=null;
    NodeClass children[]=new NodeClass[ALPHABET_SIZE];
    int occurences=0;

    public void InsertNode(NodeClass trieTree, String word){
        NodeClass currentNode=trieTree;
        int i=0;

        while(i<word.length()){
            int c=word.charAt(i)-CASE;
            if(currentNode.children[c]==null){
                currentNode.children[c]=new NodeClass();
                currentNode.children[c].parent=currentNode;

            }
            currentNode=currentNode.children[c];
            i++;
        }
        ++currentNode.occurences;
    }

    public NodeClass Search(NodeClass trieTree, String word){
        int i=0;

        while(word.charAt(i)!='\0'){
            int c=word.charAt(i)-CASE;
            if(trieTree.children[c]!=null){
                trieTree=trieTree.children[c];
                ++i;
            }
            else return null;

        }
        return (trieTree.occurences!=0?trieTree:null);
    }

}
