public class LinkedNode {
    //结点内部类
  public class Node{
        public int data;
        public Node next;
        public Node(int data){
            this.data=data;
        }
    }


    private int size=0;
    private Node firstNode;

    public LinkedNode(int date){
        firstNode=new Node(date);
        firstNode.next=null;
        size++;
    }
    public LinkedNode(){
        firstNode=null;
    }
    public int getSize() {
        return size;
    }

    public void setData(int data){
        Node currentNode=firstNode;
        if(currentNode==null){
            firstNode=new Node(data);
            size++;
            firstNode.next=null;
        }else {
            while (currentNode.next != null) {
                currentNode=currentNode.next;
            }
            Node node=new Node(data);
            currentNode.next=node;
            size++;
        }
    }
    public void insert(int index,int date){
        if(index<1||index>size+1){
            System.out.println("插入的元素不对");
        }
        //插到头
        if(index==1){
            Node node=new Node(date);//创建新的结点
            node.next=firstNode;
            firstNode=node;
            size++;
        }

        //中间
        if(index>1&&index<size+1){
            Node node=new Node(date);
            Node currentNode=firstNode;
            Node prevCurrent=firstNode;
            for (int i=1;i<index-1;i++){
                prevCurrent=prevCurrent.next;
            }
            for(int i=1;i<index;i++){
                currentNode=currentNode.next;
            }
            node.next=currentNode;
            prevCurrent.next=node;
            size++;
        }
        //插到尾
        if(index==size+1){
            setData(date);
        }
    }

    //查找
    public int findData(int data){
        int index=1;
        if(firstNode==null){
            System.out.println("链表为空");
        }else {
            Node currentNode = firstNode;
            while (currentNode!=null){
                if(currentNode.data==data){
                    System.out.println(data+"已找到，坐标为："+index);
                    return index;
                }else {
                    currentNode=currentNode.next;
                    index++;
                }
            }
        }
        return -1;
    }

    public int findIndex(int index){
        int i;
        Node currentNode = firstNode;
        if(index<1||index>size+1){
            System.out.println("查找的位置不对");
            return -1;
        }else {
            for (i=1;i<index;i++){
                currentNode=currentNode.next;
            }
            System.out.println("下标为"+index+"的数据为："+currentNode.data);
            return currentNode.data;
        }
    }

    //删除
    public void delData(int data){
        if(findData(data)==-1){
            System.out.println("链表中无此数据");
        }else {
            int index=findIndex(findData(data));
            delIndex(index);
        }
    }

    public void delIndex(int index){
        Node currentNode=firstNode;
        Node prevCurrent=firstNode;
        for (int i=1;i<index-1;i++){
            prevCurrent=prevCurrent.next;
        }
        for(int i=1;i<index;i++){
            currentNode=currentNode.next;
        }
        prevCurrent.next=prevCurrent.next.next;
        currentNode.next=null;
        size--;
    }
    public void show(){
        Node currentNode=firstNode;
        while (currentNode!=null){
            System.out.print(currentNode.data+"--->");
            currentNode=currentNode.next;
        }
        System.out.println();
    }
}
