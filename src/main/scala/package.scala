import javax.mail.internet.InternetAddress

/** An agreeable email interface for scala. */
package object courier {

  implicit class ToAddr(name: String){
    private def addr(name: String, domain: String): InternetAddress = new InternetAddress(s"$name@$domain")
    def `@`(domain: String): InternetAddress = {
      addr(name, domain)
    }
    def at = `@` _
    /** In case whole string is email address already */
    def addr = new InternetAddress(name)
  }
}
