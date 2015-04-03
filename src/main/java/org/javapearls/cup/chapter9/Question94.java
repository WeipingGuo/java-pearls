package org.javapearls.cup.chapter9;

/**
 * If you have a 2 GB file with one string per line,
 * which sorting algorithm would you use to sort the file and why?
 *
 * @author wguo
 *
 */
public class Question94 {

	// external sorting
	// suppose total data size is TOTAL MB, memory: M
	// 1. split data to TOTAL/M chunks, say K chunks
	// 2. read M into memory and sort, save the result to: file_chunk_id
	// 3. repeat 2 until for TOTAL/M steps
	// 4. K-way merge:
	// 4.1 create buffer[k], read data into it from each file
	// 4.2 create an output buffer
	// 4.3 merge and put result to output buffer
	// 4.4 when output buffer is filled, write to output file

}
