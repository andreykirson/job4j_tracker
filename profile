$ jps сначала нам нужно узнать pid нашего приложения в данном случае это 15160
10260 RemoteMavenServer36
13144 Launcher
1368 Jps
15160 AppMainV2
5820

Далее с помощью jmap, jstat, jstack, jconsole выводим статистику

Инструмент jmap ( в новых версиях jdk нужно писать как jhsdb jmap --heap --pid 14388)

$ jhsdb jmap --heap --pid 14388
Attaching to process ID 14388, please wait...
Debugger attached successfully.
Server compiler detected.
JVM version is 14.0.1+7 - версия виртуальной машины

using thread-local object allocation.
Garbage-First (G1) GC with 6 thread(s) - тип используемого коллектора

Heap Configuration:
   MinHeapFreeRatio         = 40 - минимальное доля свободного места в каждом поколение
   MaxHeapFreeRatio         = 70 - максимальное доля свободного места в каждом поколение
   MaxHeapSize              = 4273995776 (4076.0MB) максимальный размер кучи
   NewSize                  = 1363144 (1.2999954223632812MB) - размер младшего поколения
   MaxNewSize               = 2563768320 (2445.0MB)
   OldSize                  = 5452592 (5.1999969482421875MB)
   NewRatio                 = 2 - отношение размера старшего поколения к суммарному размеру регионов младшего поколения
   SurvivorRatio            = 8 отношение выживших объектов
   MetaspaceSize            = 21807104 (20.796875MB) - область памяти в JVM, предназначенная для хранения описания классов Java и некоторых дополнительных данных. По сравнению с PerGen может автоматически расширяться
   CompressedClassSpaceSize = 1073741824 (1024.0MB) - (область сжатых указателей): используется для хранения информации о загруженных классах.
   MaxMetaspaceSize         = 17592186044415 MB
   G1HeapRegionSize         = 1048576 (1.0MB)

Heap Usage:
G1 Heap:
   regions  = 4076
   capacity = 4273995776 (4076.0MB) размер сборщика мусора
   used     = 11534336 (11.0MB)
   free     = 4262461440 (4065.0MB)
   0.2698724239450442% used
G1 Young Generation:
Eden Space:
   regions  = 10
   capacity = 24117248 (23.0MB)
   used     = 10485760 (10.0MB)
   free     = 13631488 (13.0MB)
   43.47826086956522% used
Survivor Space:
   regions  = 0
   capacity = 0 (0.0MB)
   used     = 0 (0.0MB)
   free     = 0 (0.0MB)
   0.0% used
G1 Old Generation:
   regions  = 1
   capacity = 244318208 (233.0MB)
   used     = 1048576 (1.0MB)
   free     = 243269632 (232.0MB)
   0.4291845493562232% used




$ jstat -gc 15160
 S0C    S1C    S0U    S1U      EC       EU        OC         OU       MC     MU    CCSC   CCSU   YGC     YGCT    FGC    FGCT    CGC    CGCT     GCT
 0,0    0,0    0,0    0,0   23552,0  10240,0   238592,0    1024,0   4480,0 229,2  384,0   9,0        0    0,000   0      0,000   0      0,000    0,000


S0C Current survivor space 0 capacity (KB).
S1C Current survivor space 1 capacity (KB).
S0U Survivor space 0 utilization (KB).
S1U Survivor space 1 utilization (KB).
EC Current eden space capacity (KB).
EU Eden space utilization (KB).
OC Current old space capacity (KB).
OU Old space utilization (KB).
PC Current permanent space capacity (KB).
PU Permanent space utilization (KB).
YGC Number of young generation GC Events.
YGCT Young generation garbage collection time.
FGC Number of full GC events.
FGCT Full garbage collection time.
GCT Total garbage collection time.


$ jstack 15160
2020-08-29 10:55:24
Full thread dump Java HotSpot(TM) 64-Bit Server VM (14.0.1+7 mixed mode, sharing):

Threads class SMR info:
_java_thread_list=0x00000229ca2b6bd0, length=12, elements={
0x00000229a5f36800, 0x00000229c98ae000, 0x00000229c98b1000, 0x00000229ca150800,
0x00000229ca154000, 0x00000229ca155000, 0x00000229ca156800, 0x00000229ca1c7800,
0x00000229ca1c8800, 0x00000229ca297800, 0x00000229ca2b2800, 0x00000229ca3ce800
}

"main" #1 prio=5 os_prio=0 cpu=343.75ms elapsed=490.91s tid=0x00000229a5f36800 nid=0x43a4 runnable  [0x000000e7c89fe000]
   java.lang.Thread.State: RUNNABLE
        at java.io.FileInputStream.readBytes(java.base@14.0.1/Native Method)
        at java.io.FileInputStream.read(java.base@14.0.1/FileInputStream.java:272)
        at java.io.BufferedInputStream.read1(java.base@14.0.1/BufferedInputStream.java:282)
        at java.io.BufferedInputStream.read(java.base@14.0.1/BufferedInputStream.java:343)
        - locked <0x000000071131da80> (a java.io.BufferedInputStream)
        at sun.nio.cs.StreamDecoder.readBytes(java.base@14.0.1/StreamDecoder.java:297)
        at sun.nio.cs.StreamDecoder.implRead(java.base@14.0.1/StreamDecoder.java:339)
        at sun.nio.cs.StreamDecoder.read(java.base@14.0.1/StreamDecoder.java:188)
        - locked <0x00000007111f8168> (a java.io.InputStreamReader)
        at java.io.InputStreamReader.read(java.base@14.0.1/InputStreamReader.java:181)
        at java.io.Reader.read(java.base@14.0.1/Reader.java:189)
        at java.util.Scanner.readInput(java.base@14.0.1/Scanner.java:882)
        at java.util.Scanner.findWithinHorizon(java.base@14.0.1/Scanner.java:1796)
        at java.util.Scanner.nextLine(java.base@14.0.1/Scanner.java:1649)
        at ru.job4j.tracker.ConsoleInput.askStr(ConsoleInput.java:10)
        at ru.job4j.tracker.ConsoleInput.askInt(ConsoleInput.java:15)
        at ru.job4j.tracker.ConsoleInput.askInt(ConsoleInput.java:20)
        at ru.job4j.tracker.ValidateInput.askInt(ValidateInput.java:36)
        at ru.job4j.tracker.StartUI.init(StartUI.java:10)
        at ru.job4j.tracker.StartUI.main(StartUI.java:37)
        at jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(java.base@14.0.1/Native Method)
        at jdk.internal.reflect.NativeMethodAccessorImpl.invoke(java.base@14.0.1/NativeMethodAccessorImpl.java:62)
        at jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(java.base@14.0.1/DelegatingMethodAccessorImpl.java:43)
        at java.lang.reflect.Method.invoke(java.base@14.0.1/Method.java:564)
        at com.intellij.rt.execution.application.AppMainV2.main(AppMainV2.java:131)

"Reference Handler" #2 daemon prio=10 os_prio=2 cpu=0.00ms elapsed=490.89s tid=0x00000229c98ae000 nid=0x3c0c waiting on condition  [0x000000e7c90fe000]
   java.lang.Thread.State: RUNNABLE
        at java.lang.ref.Reference.waitForReferencePendingList(java.base@14.0.1/Native Method)
        at java.lang.ref.Reference.processPendingReferences(java.base@14.0.1/Reference.java:241)
        at java.lang.ref.Reference$ReferenceHandler.run(java.base@14.0.1/Reference.java:213)

"Finalizer" #3 daemon prio=8 os_prio=1 cpu=0.00ms elapsed=490.89s tid=0x00000229c98b1000 nid=0x3c94 in Object.wait()  [0x000000e7c91ff000]
   java.lang.Thread.State: WAITING (on object monitor)
        at java.lang.Object.wait(java.base@14.0.1/Native Method)
        - waiting on <0x000000071130b1b8> (a java.lang.ref.ReferenceQueue$Lock)
        at java.lang.ref.ReferenceQueue.remove(java.base@14.0.1/ReferenceQueue.java:155)
        - locked <0x000000071130b1b8> (a java.lang.ref.ReferenceQueue$Lock)
        at java.lang.ref.ReferenceQueue.remove(java.base@14.0.1/ReferenceQueue.java:176)
        at java.lang.ref.Finalizer$FinalizerThread.run(java.base@14.0.1/Finalizer.java:170)

"Signal Dispatcher" #4 daemon prio=9 os_prio=2 cpu=0.00ms elapsed=490.88s tid=0x00000229ca150800 nid=0x3a64 runnable  [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"Attach Listener" #5 daemon prio=5 os_prio=2 cpu=15.63ms elapsed=490.88s tid=0x00000229ca154000 nid=0x15ec waiting on condition  [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"Service Thread" #6 daemon prio=9 os_prio=0 cpu=0.00ms elapsed=490.88s tid=0x00000229ca155000 nid=0xeb4 runnable  [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"C2 CompilerThread0" #7 daemon prio=9 os_prio=2 cpu=78.13ms elapsed=490.88s tid=0x00000229ca156800 nid=0x2430 waiting on condition  [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE
   No compile task

"C1 CompilerThread0" #9 daemon prio=9 os_prio=2 cpu=140.63ms elapsed=490.88s tid=0x00000229ca1c7800 nid=0x3cac waiting on condition  [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE
   No compile task

"Sweeper thread" #10 daemon prio=9 os_prio=2 cpu=0.00ms elapsed=490.88s tid=0x00000229ca1c8800 nid=0x223c runnable  [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"Notification Thread" #11 daemon prio=9 os_prio=0 cpu=0.00ms elapsed=490.84s tid=0x00000229ca297800 nid=0x1a88 runnable  [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"Common-Cleaner" #12 daemon prio=8 os_prio=1 cpu=0.00ms elapsed=490.84s tid=0x00000229ca2b2800 nid=0x43c0 in Object.wait()  [0x000000e7c9aff000]
   java.lang.Thread.State: TIMED_WAITING (on object monitor)
        at java.lang.Object.wait(java.base@14.0.1/Native Method)
        - waiting on <0x00000007113aa1b0> (a java.lang.ref.ReferenceQueue$Lock)
        at java.lang.ref.ReferenceQueue.remove(java.base@14.0.1/ReferenceQueue.java:155)
        - locked <0x00000007113aa1b0> (a java.lang.ref.ReferenceQueue$Lock)
        at jdk.internal.ref.CleanerImpl.run(java.base@14.0.1/CleanerImpl.java:148)
        at java.lang.Thread.run(java.base@14.0.1/Thread.java:832)
        at jdk.internal.misc.InnocuousThread.run(java.base@14.0.1/InnocuousThread.java:134)

"Monitor Ctrl-Break" #13 daemon prio=5 os_prio=0 cpu=15.63ms elapsed=490.80s tid=0x00000229ca3ce800 nid=0x3e7c runnable  [0x000000e7c9bfe000]
   java.lang.Thread.State: RUNNABLE
        at sun.nio.ch.SocketDispatcher.read0(java.base@14.0.1/Native Method)
        at sun.nio.ch.SocketDispatcher.read(java.base@14.0.1/SocketDispatcher.java:46)
        at sun.nio.ch.NioSocketImpl.tryRead(java.base@14.0.1/NioSocketImpl.java:261)
        at sun.nio.ch.NioSocketImpl.implRead(java.base@14.0.1/NioSocketImpl.java:312)
        at sun.nio.ch.NioSocketImpl.read(java.base@14.0.1/NioSocketImpl.java:350)
        at sun.nio.ch.NioSocketImpl$1.read(java.base@14.0.1/NioSocketImpl.java:803)
        at java.net.Socket$SocketInputStream.read(java.base@14.0.1/Socket.java:982)
        at sun.nio.cs.StreamDecoder.readBytes(java.base@14.0.1/StreamDecoder.java:297)
        at sun.nio.cs.StreamDecoder.implRead(java.base@14.0.1/StreamDecoder.java:339)
        at sun.nio.cs.StreamDecoder.read(java.base@14.0.1/StreamDecoder.java:188)
        - locked <0x00000007111959c0> (a java.io.InputStreamReader)
        at java.io.InputStreamReader.read(java.base@14.0.1/InputStreamReader.java:181)
        at java.io.BufferedReader.fill(java.base@14.0.1/BufferedReader.java:161)
        at java.io.BufferedReader.readLine(java.base@14.0.1/BufferedReader.java:326)
        - locked <0x00000007111959c0> (a java.io.InputStreamReader)
        at java.io.BufferedReader.readLine(java.base@14.0.1/BufferedReader.java:392)
        at com.intellij.rt.execution.application.AppMainV2$1.run(AppMainV2.java:64)

"VM Thread" os_prio=2 cpu=15.63ms elapsed=490.89s tid=0x00000229c98a5800 nid=0x25dc runnable

"GC Thread#0" os_prio=2 cpu=0.00ms elapsed=490.90s tid=0x00000229a5f9f800 nid=0x3200 runnable

"G1 Main Marker" os_prio=2 cpu=0.00ms elapsed=490.90s tid=0x00000229a5fc1000 nid=0x4220 runnable

"G1 Conc#0" os_prio=2 cpu=0.00ms elapsed=490.90s tid=0x00000229a5fc2000 nid=0x2488 runnable

"G1 Refine#0" os_prio=2 cpu=0.00ms elapsed=490.90s tid=0x00000229c9794800 nid=0x5f8 runnable

"G1 Young RemSet Sampling" os_prio=2 cpu=0.00ms elapsed=490.90s tid=0x00000229c9795800 nid=0x27ac runnable
"VM Periodic Task Thread" os_prio=2 cpu=0.00ms elapsed=490.84s tid=0x00000229ca1fc000 nid=0x698 waiting on condition

JNI global refs: 14, weak refs: 0


Инструмент jconsole

VM Summary
суббота, 29 августа 2020 г., 11:02:28 Владивосток, стандартное время

Connection name: pid: 15160 com.intellij.rt.execution.application.AppMainV2 ru.job4j.tracker.StartUI
Virtual Machine: Java HotSpot(TM) 64-Bit Server VM version 14.0.1+7
Vendor: Oracle Corporation
Name: 15160@DESKTOP-KEFCI64
Uptime: 15 minutes
Process CPU time: 2,046 seconds
JIT compiler: HotSpot 64-Bit Tiered Compilers
Total compile time: 1,405 seconds

Live threads: 15
Peak: 15
Daemon threads:14
Total threads started:15
Current classes loaded:2 592
Total classes loaded: 2 592
Total classes unloaded:    0

Данные о куче:

Current heap size: 7 524 kbytes
Maximum heap size: 4 173 824 kbytes
Committed memory: 27 648 kbytes - какое количество памяти должно быть выделено, но не обязательно использовано для heap-области процесса JVM на момент его старта
Pending finalization: 0 objects

Тип сборщика мусора:

Garbage collector: Name = 'G1 Young Generation', Collections = 0, Total time spent = 0,000 seconds
Garbage collector: Name = 'G1 Old Generation', Collections = 1, Total time spent = 0,008 seconds


Данные о системе:

Operating System: Windows 10 10.0
Architecture: amd64
Number of processors: 6
Committed virtual memory: 122 112 kbytes
Total physical memory: 16 692 188 kbytes
Free physical memory:  9 592 876 kbytes
Total swap space: 19 182 556 kbytes
Free swap space:  8 133 348 kbytes