resource "aws_instance" "project-instance" {
   ami=var.ami
   instance_type = var.instance_type
   vpc_security_group_ids = [aws_security_group.jenkins_sg.id]
  root_block_device {
    volume_size = 100
  }

  tags = {
    Name = "jenkins-instance"
  }

  
}




resource "aws_security_group" "jenkins_sg" {

    ingress {
    from_port = 22
    to_port   = 22
    protocol  = "tcp"

    cidr_blocks = ["0.0.0.0/0"]
  }




   ingress {
    from_port = 80
    to_port   = 80
    protocol  = "tcp"

    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    from_port = 443
    to_port   = 443
    protocol  = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    from_port = 8080
    to_port   = 8080
    protocol  = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    from_port = 9092
    to_port   = 9092
    protocol  = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

    ingress {
    from_port = 8081
    to_port   = 8081
    protocol  = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

   egress {
      cidr_blocks      = ["0.0.0.0/0"]
      from_port        = 0
      protocol         = "-1"
      to_port          = 0
    }
  
 


}


# resource "aws_s3_bucket" "s3-bucket" {
#   bucket = var.bucketname
# }

