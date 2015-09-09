/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apjsd2;

/**
 *
 * @author zaf
 */
class Node{
    int jam;
    String matpel, guru;
    Node next;
    Node(int jam, String matpel, String guru){
        this.jam = jam;
        this.matpel = matpel;
        this.guru = guru;
    }
}
class LinkedList{
    Node head, tail, current;
    LinkedList(){
            head = tail = current = null;
    }
    boolean kosongCek(){
            return (head==null);
    }
    void tambahAwal(int jam, String matpel, String guru){
            Node nd = new Node(jam, matpel, guru);
            if (kosongCek()){
                    head = tail = nd;
            } else {
                    nd.next = head;
                    head = nd;
            }
    }
    void tambahAkhir(int jam, String matpel, String guru){
            Node nd = new Node(jam, matpel, guru);
            if (kosongCek()){
                    head = tail = nd;
            } else {
                    tail.next = nd;
                    tail = nd;
            }
    }
    void tampil(){
	current=head;
	while(current!=null){
		System.out.println(current.matpel+", "+current.jam+", "+current.guru);
		current=current.next;
	}
    }
}
public class Generate{
    boolean complete;
    Node current;
    Query q;
    LinkedList l;
    Generate(){
        complete = true;
        current = null;
        q = new Query();
    }
    void buildLinkedList(){
        l = new LinkedList();
        try {
            hasil = q.getMatpel();
            while (hasil.next()){
                l.tambahAkhir(hasil.getInt("jam"), hasil.getString("matpel"), hasil.getString("guru"));
            }
        } catch (Exception e){

        }
    }
    void insertListToDatabase(int[] jam, int[] kelas, String[] hari){
        for (int i=0; i<kelas.length; i++){
            System.out.println("\nmembuat list dengan data baru");
            buildLinkedList();
            current = l.head;
            for (int j=0; j<hari.length && isAnyJam(l.head); j++){
                System.out.println("hari : "+hari[j]);
                if (hari[j] != null){
                    for (int k=0; k<jam.length && isAnyJam(l.head); k++){
                        // perkiraan tidak sampai habis :-)
                        // melakukan advance jika objek matpel ada yang colission dengan hari dan jam yang sama
                        while (q.isCollision(hari[j], jam[k], current.matpel)){
                            current = current.next;
                        }
                        // melakukan advance untuk mencari matpel yang masih memiliki jam (jam != 0)
                        while (current.jam == 0 && current != null){
                            current = current.next;
                        }

                        q.insertJadwal(hari[j], kelas[i], jam[k], current.matpel);
                        current.jam -= 1;
//                        System.out.println(hari[j]+", "+kelas[i]+", "+jam[k]+", "+current.matpel+", "+q.isCollision(hari[j], jam[k], current.matpel)+", "+isAnyJam(l.head));
                        if (current.jam == 0) current = current.next;
                        if (current == null) current = l.head;
                    }
                }
                    
            }
            if (isAnyJam(l.head)) complete = false;
            else complete = true;
        }
    }
    boolean isAnyJam(Node head){
        int i = 0;
        Node tmp = head;
        while (tmp != null){
            if (tmp.jam != 0) i++;
            tmp = tmp.next;
        }
        if (i != 0) return true;
        else return false;
    }
    void show(){
        l.tampil();
    }
    
    private java.sql.ResultSet hasil;
    private java.sql.Statement perintah;
}