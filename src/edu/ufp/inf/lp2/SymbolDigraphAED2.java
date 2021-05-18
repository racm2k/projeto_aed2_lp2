/******************************************************************************
 *  Compilation:  javac SymbolDigraph.java
 *  Execution:    java SymbolDigraph
 *  Dependencies: ST.java Digraph.java In.java
 *  Data files:   https://algs4.cs.princeton.edu/42digraph/routes.txt
 *
 *  %  java SymbolDigraph routes.txt " "
 *  JFK
 *     MCO
 *     ATL
 *     ORD
 *  ATL
 *     HOU
 *     MCO
 *  LAX
 *
 ******************************************************************************/

package edu.ufp.inf.lp2;

import edu.princeton.cs.algs4.*;

import java.sql.Time;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * The {@code SymbolDigraph} class represents a digraph, where the
 * vertex names are arbitrary strings.
 * By providing mappings between string vertex names and integers,
 * it serves as a wrapper around the
 * {@link Digraph} data type, which assumes the vertex names are integers
 * between 0 and <em>V</em> - 1.
 * It also supports initializing a symbol digraph from a file.
 * <p>
 * This implementation uses an {@link ST} to map from strings to integers,
 * an array to map from integers to strings, and a {@link Digraph} to store
 * the underlying graph.
 * The <em>indexOf</em> and <em>contains</em> operations take time
 * proportional to log <em>V</em>, where <em>V</em> is the number of vertices.
 * The <em>nameOf</em> operation takes constant time.
 * <p>
 * For additional documentation, see <a href="https://algs4.cs.princeton.edu/42digraph">Section 4.2</a> of
 * <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
public class SymbolDigraphAED2 {
    private ST<Cache, Integer> st;  // string -> index
    private Cache[] keys;           // index  -> string
    private EdgeWeightedDigraphAED2 graph;           // the underlying digraph

    /**
     * Initializes a digraph from a file using the specified delimiter.
     * Each line in the file contains
     * the name of a vertex, followed by a list of the names
     * of the vertices adjacent to that vertex, separated by the delimiter.
     *
     * @param filename  the name of the file
     * @param delimiter the delimiter between fields
     */
    public SymbolDigraphAED2(String filename, String delimiter,FileUtils fu) {
        st = new ST<Cache, Integer>();

        // First pass builds the index by reading strings to associate
        // distinct strings with an index
        In in = new In(filename);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(delimiter);
            Cache c = fu.getCache(Integer.parseInt(a[0]));
            Cache c1 = fu.getCache(Integer.parseInt(a[1]));
            System.out.println(fu.getCache(2));
            if (!st.contains(c1)) {
                st.put(c1, st.size());
            }
            if (!st.contains(c)) {
                st.put(c, st.size());
            }
        }

        // inverted index to get string keys in an array
        keys = new Cache[st.size()];
        for (Cache name : st.keys()) {
            keys[st.get(name)] = name;
        }

        // second pass builds the digraph by connecting first vertex on each
        // line to all others
        graph = new EdgeWeightedDigraphAED2(st.size());
        in = new In(filename);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(delimiter);
            Cache c = fu.getCache(Integer.parseInt(a[0]));
            Cache c1 = fu.getCache(Integer.parseInt(a[1]));
            int v = st.get(c);
            int w = st.get(c1);
            double distance = distance(c.getLocal_cache().getLatitude(),c.getLocal_cache().getLongitude(),c1.getLocal_cache().getLatitude(),c1.getLocal_cache().getLongitude(),"K");
            float speed = Float.parseFloat(a[2]);
            double time = distance / speed * 60;
            int elevacao = Integer.parseInt(a[3]);
            if (0<elevacao && elevacao<=200){
                time *=1.25;
            }else if(200<elevacao && elevacao<=400){
                time*=1.45;
            }else if(400<elevacao && elevacao<=600){
                time*=1.65;
            }else{
                time*=2;
            }
            DirectedEdge de = new DirectedEdge(v, w,distance , time);
            graph.addEdge(de);

        }
    }


    private static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
        if ((lat1 == lat2) && (lon1 == lon2)) {
            return 0;
        }
        else {
            double theta = lon1 - lon2;
            double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;
            if (unit.equals("K")) {
                dist = dist * 1.609344;
            } else if (unit.equals("N")) {
                dist = dist * 0.8684;
            }
            return (dist);
        }
    }

    /**
     * Does the digraph contain the vertex named {@code s}?
     *
     * @param s the name of a vertex
     * @return {@code true} if {@code s} is the name of a vertex, and {@code false} otherwise
     */
    public boolean contains(Cache s) {
        return st.contains(s);
    }

    /**
     * Returns the integer associated with the vertex named {@code s}.
     *
     * @param s the name of a vertex
     * @return the integer (between 0 and <em>V</em> - 1) associated with the vertex named {@code s}
     * @deprecated Replaced by {@link #indexOf(Cache)}.
     */
    @Deprecated
    public int index(Cache s) {
        return st.get(s);
    }

    /**
     * Returns the integer associated with the vertex named {@code s}.
     *
     * @param s the name of a vertex
     * @return the integer (between 0 and <em>V</em> - 1) associated with the vertex named {@code s}
     */
    public int indexOf(Cache s) {
        return st.get(s);
    }

    /**
     * Returns the name of the vertex associated with the integer {@code v}.
     *
     * @param v the integer corresponding to a vertex (between 0 and <em>V</em> - 1)
     * @return the name of the vertex associated with the integer {@code v}
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     * @deprecated Replaced by {@link #nameOf(int)}.
     */
    @Deprecated
    public Cache name(int v) {
        validateVertex(v);
        return keys[v];
    }

    /**
     * Returns the name of the vertex associated with the integer {@code v}.
     *
     * @param v the integer corresponding to a vertex (between 0 and <em>V</em> - 1)
     * @return the name of the vertex associated with the integer {@code v}
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public Cache nameOf(int v) {
        validateVertex(v);
        return keys[v];
    }

    /**
     * Returns the digraph assoicated with the symbol graph. It is the client's responsibility
     * not to mutate the digraph.
     *
     * @return the digraph associated with the symbol digraph
     * @deprecated Replaced by {@link #digraph()}.
     */
    @Deprecated
    public EdgeWeightedDigraphAED2 G() {
        return graph;
    }

    /**
     * Returns the digraph assoicated with the symbol graph. It is the client's responsibility
     * not to mutate the digraph.
     *
     * @return the digraph associated with the symbol digraph
     */
    public EdgeWeightedDigraphAED2 digraph() {
        return graph;
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        int V = graph.V();
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
    }

    /**
     * Unit tests the {@code SymbolDigraph} data type.
     *
     * @param args the command-line arguments
     */
//    public static void main(String[] args) {
//        String filename = args[0];
//        String delimiter = args[1];
//        SymbolDigraphAED2 sg = new SymbolDigraphAED2(filename, delimiter);
//        E graph = sg.digraph();
//        while (!StdIn.isEmpty()) {
//            String t = StdIn.readLine();
//            for (int v : graph.adj(sg.index(t))) {
//                StdOut.println("   " + sg.name(v));
//            }
//        }
//    }
}

/******************************************************************************
 *  Copyright 2002-2020, Robert Sedgewick and Kevin Wayne.
 *
 *  This file is part of algs4.jar, which accompanies the textbook
 *
 *      Algorithms, 4th edition by Robert Sedgewick and Kevin Wayne,
 *      Addison-Wesley Professional, 2011, ISBN 0-321-57351-X.
 *      http://algs4.cs.princeton.edu
 *
 *
 *  algs4.jar is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  algs4.jar is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with algs4.jar.  If not, see http://www.gnu.org/licenses.
 ******************************************************************************/
