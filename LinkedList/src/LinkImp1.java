public class LinkImp1 implements Link {
    private Node root;
    private int count=0;
    private int foot=0;

    private class Node {
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }

        public void addNode(Node newNode) {
            if (this.next==null){
                this.next=newNode;
            }else {
                this.next.addNode(newNode);
            }

        }

        public void printNode() {
            System.out.println(this.data);
            if (this.next==null){
                return;
            }else {
                this.next.printNode();
            }
        }

    }


    @Override
    public void add(Object data) {
        Node newNode=new Node(data);
        if (root==null){
            root=newNode;
        }else {
            root.addNode(newNode);
        }
        count++;
    }

    @Override
    public void print() {
        if (root==null){
            System.out.println("null");
        }else {
            root.printNode();
        }
    }

    @Override
    public int size() {
      return count;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

//    @Override
//    public boolean contains(Object data) {
//        if (root==null){
//            return false;
//        }else {
//            return root.containsNode(data);
//        }
//    }

//    @Override
//    public Object get(int index) {
//        if (index>count-1||index<0){
//            return null;
//        }else {
//            return root
//        }
//    }

//    @Override
//    public void set(int index, Object data) {
//        if (index>count-1||index<0){
//            return ;
//        }else {
//            return root
//        }
//    }

    @Override
    public void remove(Object data) {
        if (root==null){
            return;
        }else {

        }
    }


}
