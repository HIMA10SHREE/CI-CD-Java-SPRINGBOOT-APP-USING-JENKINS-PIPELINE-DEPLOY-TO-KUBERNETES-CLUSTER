terraform {
  backend "s3" {
    bucket = "jenkinsbucket-hima12"
    key    = "hima/terraform.tfstate"
    region = "us-east-2"
  }
}