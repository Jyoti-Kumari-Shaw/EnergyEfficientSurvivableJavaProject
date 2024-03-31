# Ennergy Efficient Survivable Multipath Based Approaches in Space Division Multiplexing Elastic Optical Netwrok: Crosstalk Aware,Fragmentation Aware 
we have proposed two energy-efficient heuristics: (i) CMDE-RSCA
(crosstalk-aware), and (ii) FMDE-RSCA (fragmentation-aware) to address the issues of inter-core crosstalk,
and fragmentation within the core respectively- to ensure quality transmission of the optical signal for
dynamic traffic in space division multiplexing elastic optical network (SDM-EON), while maintaining sur-
vivability of the network against single link failure. These heuristics based on multipath based survivability
are compared with three existing survivable approaches based on p-cycles and shared path in terms of
bandwidth blocking, energy consumption, crosstalk, and fragmentation. Both these algorithms outperform
all three existing heuristics in terms of all parameters. In between CMDE-RSCA and FMDE-RSCA,
CMDE-RSCA leads to consume lesser energy, whereas FMDE-RSCA produces lesser bandwidth blocking.

#Problem Defination:-The SDM-EON is represented as a graph G = (V, E,C)
where V, E, and C are the sets of nodes, links, and cores
present in each link respectively. Each connection arrives
randomly as R < s, d, B, q > where s and d are the source
and the destination nodes respectively, B is the bandwidth
demand and q is the protection ratio, 0 < q < 1. The graph
is modeled in the form of a multi-graph [5] i.e. the graph may
be divided into n subgraphs where n = |C|. Multipath based
survivability ensures the communication of minimum B · q
amount of traffic in between s-d pair of a connection request
even if a single link fails in any of the selected multipath for
the request.
The objective is to design two distance adaptive
RSCA heuristics: crosstalk-aware and fragmentation aware
for SDM-EON under dynamic environment having the
characteristics as follows:

i) Survivability based on multipath to reduce spectral frag-
mentation and bandwidth blocking ratio to a large extent .

ii) Energy-efficiency obtained by selecting proper paths to
reduce power-consuming network elements .
Assumptions:
i) At least two link-disjoint paths must exist between
each node pair of the network to ensure multipath based
survivability.
ii) Number of paths to be selected in multipath based
survivability is considered to be either two or three.
iii) Cores are classified into various regions
which helps reduce spectral fragmentation to a great
extent .
iv) Core switching has not been considered here.
v) Spectrums of different connections can be allocated
in consecutive slots of fixed size regions without any
interference .
