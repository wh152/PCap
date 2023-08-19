## PCap
Packet capture application for Windows that uses [Npcap](https://npcap.com/) to interface with the kernel, using modern FFI solutions [jextract](https://github.com/kaitoy/pcap4j) and the `lang.foreign` API to request the Npcap user-space library. Currnetly in development, `PCap` aims to provide a GUI to view, group and filter network packets based on properties such as:
* Source/destination IP/MAC address
* Port number
* Protocol
* NIC
* Session
* Frequency
---
### Setting up `PCap` 
After downloading [Npcap's SDK](https://npcap.com/dist/npcap-sdk-1.13.zip/) and [building jextract](https://github.com/openjdk/jextract#building--testing), run the following command in the project directory to generate the Java bindings required for `Npcap` API calls:
```
jextract -t org.npcap --output src/main/java -l"C:\Windows\System32\Npcap\wpcap.dll" -I"C:\Program Files\Npcap\include" --source @includes.txt "C:\Program Files\Npcap\include\pcap\pcap.h"
```
Then locate PCap.java in the com.github.wh152 package and run its main method.