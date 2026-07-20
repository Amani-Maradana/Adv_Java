package com.codegnan.sms.util;
import java.io.PrintWriter;
/**
* Tiny HTML page builder used by every servlet so that all pages share
* the same header / navigation bar / footer and the same stylesheet,
* without using JSP. Only plain HTML + CSS is produced.
*/
public final class HtmlPage {
   private HtmlPage() {
   }
   public static void writeHeader(PrintWriter out, String ctx, String title) {
       out.println("<!DOCTYPE html>");
       out.println("<html lang=\"en\">");
       out.println("<head>");
       out.println("<meta charset=\"UTF-8\">");
       out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
       out.println("<title>" + escape(title) + " | Student Management System</title>");
       out.println("<link rel=\"stylesheet\" href=\"" + ctx + "/css/style.css\">");
       out.println("</head>");
       out.println("<body>");
       writeNav(out, ctx);
       out.println("<main class=\"container\">");
   }
   private static void writeNav(PrintWriter out, String ctx) {
       out.println("<header class=\"site-header\">");
       out.println("  <div class=\"brand\">Student Management System</div>");
       out.println("  <nav class=\"site-nav\">");
       out.println("    <a href=\"" + ctx + "/index.html\">Home</a>");
       out.println("    <a href=\"" + ctx + "/add-student.html\">Add Student</a>");
       out.println("    <a href=\"" + ctx + "/list\">View All</a>");
       out.println("    <a href=\"" + ctx + "/search-by-id.html\">Search by ID</a>");
       out.println("    <a href=\"" + ctx + "/search-by-course.html\">Search by Course</a>");
       out.println("    <a href=\"" + ctx + "/update-marks.html\">Update Marks</a>");
       out.println("    <a href=\"" + ctx + "/delete-student.html\">Delete</a>");
       out.println("  </nav>");
       out.println("</header>");
   }
   public static void writeFooter(PrintWriter out) {
       out.println("</main>");
       out.println("<footer class=\"site-footer\">&copy; Student Management System &mdash; Servlets + JDBC</footer>");
       out.println("</body>");
       out.println("</html>");
   }
   public static void writeSuccess(PrintWriter out, String message, String ctx) {
       out.println("<div class=\"alert alert-success\">" + escape(message) + "</div>");
       out.println("<a class=\"btn\" href=\"" + ctx + "/index.html\">Back to Home</a>");
   }
   public static void writeError(PrintWriter out, String message, String ctx) {
       out.println("<div class=\"alert alert-error\">" + escape(message) + "</div>");
       out.println("<a class=\"btn\" href=\"" + ctx + "/index.html\">Back to Home</a>");
   }
   /** Minimal HTML-escaping to keep user-entered data from breaking the page markup. */
   public static String escape(Object value) {
       if (value == null) {
           return "";
       }
       return value.toString()
               .replace("&", "&amp;")
               .replace("<", "&lt;")
               .replace(">", "&gt;")
               .replace("\"", "&quot;")
               .replace("'", "&#39;");
   }
}
