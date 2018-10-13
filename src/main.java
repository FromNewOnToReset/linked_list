public class main {
    public static void main(String []args){
        LinkedNode linkedNode=new LinkedNode();
        linkedNode.setData(2);
        linkedNode.setData(3);

        System.out.println(linkedNode.getSize());

        linkedNode.insert(2,6);
        System.out.println(linkedNode.getSize());
        linkedNode.show();

        linkedNode.findIndex(2);
        linkedNode.findData(2);
        linkedNode.delIndex(2);
        System.out.println(linkedNode.getSize());
        linkedNode.show();
        linkedNode.delData(2);
        System.out.println(linkedNode.getSize());
        linkedNode.show();
    }
}
