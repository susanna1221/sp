20173954 유진

HolubSQL.jar
Version 1.0
Released 27 Sept., 2004

/*  (c) 2004 Allen I. Holub. All rights reserved.
 *
 *  This code may be used freely by yourself with the following
 *  restrictions:
 *
 *  o Your splash screen, about box, or equivalent, must include
 *    Allen Holub's name, copyright, and URL. For example:
 *
 *      This program contains Allen Holub's SQL package.<br>
 *      (c) 2005 Allen I. Holub. All Rights Reserved.<br>
 *              http://www.holub.com<br>
 *
 *    If your program does not run interactively, then the foregoing
 *    notice must appear in your documentation.
 *
 *  o You may not redistribute (or mirror) the source code.
 *
 *  o You must report any bugs that you find to me. Use the form at
 *    http://www.holub.com/company/contact.html or send email to
 *    allen@Holub.com.
 *
 *  o The software is supplied <em>as is</em>. Neither Allen Holub nor
 *    Holub Associates are responsible for any bugs (or any problems
 *    caused by bugs, including lost productivity or data)
 *    in any of this code.
 */

DP2020Project

src디렉토리:
com.holub.database:

-Basic(변경사항 없음): 

Cursor
TableFactory
Selector

-Modified:

Table: 테이블의 column names를 리턴하는 메소드 추가
ConcreteTable: 테이블의 column names를 리턴하는 메소드 추가, Visitor로 구현된 기능 사용하는 코드 추가, Select * (join) 문제 해결 위해 getRequestedColumnsForStar메소드 추가
UnmodifiableTable: 테이블의 column names를 리턴하는 메소드 추가
CSVImporter: Visitor 패턴 구현을 위해 accept 메소드 추가
CSVExporter: Visitor 패턴 구현을 위해 accept 메소드 추가
JTableExporter: Visitor 패턴 구현을 위해 accept 메소드 추가
Database: Distinct 기능 구현을 위해 수정

-New:
HTMLExporter: 테이블을 html 형태로 저장할 수 있는 기능. Table.exporter 인터페이스로부터 구현
XMLExporter: 테이블을 xml 형태로 저장할 수 있는 기능. Table.exporter 인터페이스로부터 구현
XMLImporter: xml파일로 부터 데이터를 읽어오는 기능. Table.importer 인터페이스로부터 구현

TestImpExp: 생성한 Importer, Exporter를 Test(Junit @Test)
Test:  Importer, Exporter를 Test(Junit assertequals())

ImporterVisitor: Importer를 대상으로 하는 Visitor 인터페이스
ImporterVisitorCheck: 현재 Import하는 파일의 종류와 tableName을 출력. ImporterVisitor 인터페이스로부터 구현. 
ImporterVisitorGetCol: 현재 Import하는 파일의 Column Names를 출력. ImporterVisitor 인터페이스로부터 구현. 
ImporterVisitorGetData: 현재 Import하는 파일이 data를 import했다는 내용을 출력. ImporterVisitor 인터페이스로부터 구현. 
ImporterVisitorGetEnd: Import가 완료되었다는 내용을 출력. ImporterVisitor 인터페이스로부터 구현. 
	=> 상기 4개의 클래스는 Import하는 과정에서 현재 어느 과정을 진행 중인지 알려주기 위함

ExporterVisitor: Exporter를 대상으로 하는 Visitor 인터페이스
ExporterVisitorCheck: 현재 Table을 Export하기 시작했다는 내용을 출력. ExporterVisitor 인터페이스로부터 구현. 
ExporterVisitorStoreMeta: MetaData를 저장했다는 내용을 출력. ExporterVisitor 인터페이스로부터 구현. 
ExporterVisitorStoreRow: Table의 Row에 저장된 데이터를 저장했다는 내용을 출력. ExporterVisitor 인터페이스로부터 구현. 
ExportedrVisitorEnd: Export가 완료되었음을 알리는 내용을 출력. ExporterVisitor 인터페이스로부터 구현. 
	=> 상기 4개의 클래스는 Export하는 과정에서 현재 어느 과정을 진행 중인지 알려주기 위함

TestforVisitor: 위에서 제작한 ExporterVisitor와 ImporterVisitor가 정상 작동하는지를 확인하기 위한 클래스.
ProcessDeco: Distinct와 Orderby를 구현하기 위해 생성한 Decorator pattern abstract class.
SelectViewDistinct: distinct 기능을 수행하는 클래스. ProcessDeco 추상 클래스를 상속받아 구현.



Dbase 디렉토리:

Input 및 Output 파일. Output파일은 원래 c:/dp2020에 생성되나 제출을 위해 이 디렉토리로 복사해 옴.

address.csv: 기존 address파일
address.html: HTMLExporter 테스트를 위해 만들어진 Output 파일
address.xml: XMLExporter 테스트를 위해 만들어진 Output 파일
address_from_xml: XMLImporter 테스트를 위해 만들어진 Output 파일
address_new.html: HTMLExporter 테스트를 위해 만들어진 Output 파일
adress_new.xml: XMLExporter 테스트를 위해 만들어진 Output 파일
name.csv: 기존 name파일
name.html: HTMLExporter 테스트를 위해 만들어진 Output 파일
name.xml: XMLExporter 테스트를 위해 만들어진 Output 파일
name_from_xml: XMLImporter 테스트를 위해 만들어진 Output 파일
test.csv: Distinct 기능 실험 중 distinct 뒤에 복수개가 오는 것을 실험하기 위한 CSV파일


이하 다른 디렉토리 변경사항 없음.



