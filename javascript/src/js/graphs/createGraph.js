class Graph {

    constructor() {
        this.map = new Map();
        this.visited = new Map();
    }

    addVertex(vertex) {
        undefined === this.map[vertex] ? this.map.set(vertex,[]) : "";
    }

    addEdge(vertex1, vertex2) {
        if(this.map.has(vertex1)) {
            let route = this.map.get(vertex1);
            route.push(vertex2);
        }

        if(this.map.has(vertex2)) {
            let route = this.map.get(vertex2) ;
            route.push(vertex1);
        }
    }

    removeEdge(vertex1, vertex2) {
        if(this.map.has(vertex1)) {
             var list = this.map.get(vertex1);
             var index = list.indexOf(vertex2)
             if( index !== -1) {
                 list.splice(index,1);
             }
        }
        if(this.map.has(vertex2)) {
            var list = this.map.get(vertex2);
            var index = list.indexOf(vertex1)
            if( index !== -1) {
                list.splice(index,1);
            }
       }
    }

    removeVertex(vertex) {
        if(this.map.has(vertex)) {
            var states = this.map.get(vertex);
            this.map.delete(vertex)
            for(var i of states) {
                 this.removeEdge(i,vertex);
            }
        }
         
    }

    inOrderTraversal(vertex) {
        if(vertex != null) {
            var arr = this.map.get(vertex);
                this.visited.set(vertex,true);
                for(var i of arr) {
                    if(!this.visited.has(i)) {
                        console.log("Visited => " + i);
                        this.inOrderTraversal(i);
                    }
                    
                }
        }
    }

    iterativeTraversal(vertex) {
        var arr = [];
        this.visited.clear();
        arr.push(vertex);
        while(arr.length != 0) {
           var element = arr.pop();
           console.log("Current element is => " , arr, element)
           if(!this.visited.has(element)) {
                this.visited.set(element,true);
                for(var k of this.map.get(element)) {
                    console.log("Why am I getting added => ", k,this.visited)
                    arr.push(k);
                }     
           } 
          
            // console.log("after adding nodes => " , arr.length)
        }

    }

    bfs(vertex) {
        var arr = [];
        arr.push(vertex);
        while(arr.length != 0) {
            var element = arr.shift()
          
            if(!this.visited.has(element)) {
                console.log("Visiting Elements => ", this.visited, element)
                this.visited.set(element,true);
                for(var k of this.map.get(element)) {
                    arr.push(k);
                }
            } 
        }

    }

}

let graph = new Graph();
graph.addVertex('tn')
graph.addVertex('ka')
graph.addVertex('ap')
graph.addVertex('kl')
graph.addVertex('mp')
graph.addVertex('goa')
graph.addVertex('or')

graph.addEdge('ka','tn')
graph.addEdge('tn','kl')
graph.addEdge('ka','kl')
graph.addEdge('ap','mp')
graph.addEdge('tn','ap')
graph.addEdge('ka','goa')
graph.addEdge('ap','or')
graph.addEdge('ka','ap')

// graph.addEdge('usa','india')


// graph.removeVertex('tn')
console.log(graph)
// graph.removeVertex('ap')
// graph.removeVertex('ka')
// graph.removeVertex('kl')
// graph.removeVertex('goa')
// graph.removeVertex('or')
// graph.removeVertex('mp')
// graph.inOrderTraversal('ka')
// graph.iterativeTraversal('ka');
graph.bfs('ka')
// console.log(graph)