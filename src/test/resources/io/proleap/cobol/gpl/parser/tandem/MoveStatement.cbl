 IDENTIFICATION DIVISION.
 PROGRAM-ID. MOVESTMT.
 DATA DIVISION.
 WORKING-STORAGE SECTION.
 77 SOME-TEXT PICTURE IS X(9).
 77 SOME-TEXT2 PICTURE IS X(9).
 77 SOME-NUMBER PIC 99 COMP.
 PROCEDURE DIVISION.
     MOVE "Test" TO SOME-TEXT.
     MOVE 1 TO SOME-NUMBER.
     MOVE SOME-TEXT TO SOME-TEXT2.