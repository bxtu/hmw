package stack;
public class Stack {
    int stackbaşı;
    String []stack;
    int stackboyut;
    Stack(int stackboyut){
        this.stackboyut = stackboyut;
        this.stack=new String[stackboyut];//creating array
        this.stackbaşı=-1;//-1 veriyorum çünkü artırıldığında bağlı listenin ilk elemanı yani 0. elemanı göstermeli
    }
    void pushopen(String string ){
        if(stackbaşı== stackboyut -1){
            stackboyutuartırma();
        }
        System.out.println("Ekleme: "+string);
        this.stack[++stackbaşı] = string;
    }
    void push(String string,int number ){
        if(stackbaşı== stackboyut -1){
            stackboyutuartırma();
        }
        System.out.println("Ekleme: "+string+": "+number);
        this.stack[++stackbaşı] = string+":"+number;
    }
    String pop(){
        if(stackboyut <1){
            System.out.println("stack is empty");
        }
        int i=0;
        String string=this.stack[stackbaşı];
        stackbaşı--;
        stackboyut--;
        System.out.println("Çıkarılan Değer: "+string);
        return string;
    }
    private void stackboyutuartırma(){
        String[] newStack = new String[this.stackboyut +1];
        for(int i = 0; i< stackboyut; i++){
            newStack[i] = this.stack[i];
        }
        this.stack = newStack;
        this.stackboyut = this.stackboyut +1;
    }
}
