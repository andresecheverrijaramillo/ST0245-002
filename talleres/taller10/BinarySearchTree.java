public class BinarySearchTree {

     private Node root;
  
    
        // Constructor sin parametros iniciar sin nodo
    public BinarySearchTree() {
        this.root = null;
    } //T(n)=O(1)
    //Contructor iniciando con nodo
    public BinarySearchTree(int n) {
        this.root = new Node(n);
    } //T(n)=O(1)

    //Llama al metodo auxiliar insertar
    public void insertar(int n) {
        insertarAux(root, n);
    } //T(n)=O(1) 
    // Agrega un nodo al arbol
    private void insertarAux(Node node, int n) {
        if (node.data == n){ //T(n)=c1
            return; //T(n)=c2
        }else if (n > node.data) { //T(n)=c3
            if (node.right == null) { //T(n)=c4
                node.right = new Node(n); //T(n)=c5
            }else { //T(n)=c6
                insertarAux(node.right, n); //T(n)=c7 + T(m-1)
            }
        }else { //T(n)=c8
            if (node.left == null) { //T(n)=c9
                node.left = new Node(n); //T(n)=c10
            }else { //T(n)=c11
                insertarAux(node.left, n); //T(n)=c12 + T(m-1)
            }
        }
        /*
         * T(m)= c1+c2+c3+c4+c5+c6+c7+c8+c9+c10+c11+c12+2T(m-1)
         * T(m) = 2T(m-1)
         * T(m) es O(c2^n-1)
         * T(m) es O(2^n-1)
         */
    }
  
    // Llama al metodo auxiliar buscar
    public boolean buscar(int n) {
        return buscarAux(root, n); //T(n)=c13
    }
    
    //Busca en el arbol si existe un valor, devuelve true o false, dependiendo de si este o no
    private boolean buscarAux(Node node, int n) {
        if (node.data == n) { //T(n)=c14
            return true; //T(n)=c15
        }
        if (node == null) { //T(n)=c16
            return false; //T(n)=c17
        }
        if (n > node.data) { //T(n)=c18
            return buscarAux(node.left, n); //T(n)=c19 + T(m-1)
        }
        return buscarAux(node.right, n); //T(n)=c20 + T(m-1)
        /*
         * T(m)= c14+c15+c16+c17+c18+c19+c20+2T(m-1)
         * T(m) = 2T(m-1)
         * T(m) es O(c2^n-1)
         * T(m) es O(2^n-1)
         */
    }

    //Llama al metodo auxiliar borrar
    public void borrar(int n) {
        borrarAux(root, n); //T(n)=c21
    }
    
    //Borra un nodo el arbol
     private Node borrarAux(Node node, int n) {
        if (node == null) { //T(n)=c22
            return null; //T(n)=c23
        }
        if (node.data == n) { //T(n)=c24
            if (node.left == null && node.right == null) { //T(n)=c25
                return null; //T(n)=c26
            }
            if (node.right == null) { //T(n)=c27
                return node.left; //T(n)=c28
            }
            if (node.left == null) { //T(n)=c29
                return node.right; //T(n)=c30
            }else { //T(n)=c31
                node.data = encontrarNodoReemplazo(node.left); //T(n)=c32
            }
        }
        if (n > node.data) { //T(n)=c33
            node.right = borrarAux(node.right, n); //T(n)=c34 + T(m-1)
            return node; //T(n)=c35
        }
        node.left = borrarAux(node.left, n); //T(n)=c36 + T(m-1)
        return node; //T(n)=c37
        /*
         * T(m)= c22+c23+c24+c25+c26+c27+c28+c29+c30+c31+c32+c33+c34+c35+c36+c37+2T(m-1)
         * T(m) = 2T(m-1)
         * T(m) es O(c2^n-1)
         * T(m) es O(2^n-1)
         */
    }
    
    private int encontrarNodoReemplazo(Node n) {
        if (n.right == null) { //T(n)=c38
            int res = n.data; //T(n)=c39
            n = null; //T(n)=c40
            return res; //T(n)=c41
        }
        return encontrarNodoReemplazo(n.right); //T(n)=c42
        /*
         T(m)= c28+c29+c30+c31+c32
         T(m) es O(c28+c29+c30+c31+c32)
         T(m) es O(1)
         */
    }
}
